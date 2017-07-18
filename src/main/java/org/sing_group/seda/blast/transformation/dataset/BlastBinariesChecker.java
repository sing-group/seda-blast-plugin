package org.sing_group.seda.blast.transformation.dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import org.sing_group.seda.blast.datatype.blast.BlastEnvironment;
import org.sing_group.seda.blast.datatype.blast.BlastType;

public class BlastBinariesChecker {

  public static void checkBlastPath(File path) throws BinaryCheckException {
    checkMakeBlastDb(path);
    checkBlastDbAliasTool(path);
    checkBlastCommands(path);
  }

  private static void checkMakeBlastDb(File path) throws BinaryCheckException {
    checkCommand(composeBlastCommand(path, BlastEnvironment.getInstance().getMakeBlastDbCommand()));
  }

  private static void checkBlastDbAliasTool(File path) throws BinaryCheckException {
    checkCommand(composeBlastCommand(path, BlastEnvironment.getInstance().getBlastDbAliasToolCommand()));
  }

  public static String composeBlastCommand(String command) {
    return composeBlastCommand(null, command);
  }

  private static void checkBlastCommands(File path) throws BinaryCheckException {
    for (BlastType blastType : BlastType.values()) {
      String command = composeBlastCommand(path, blastType.getCommand());
      checkCommand(command);
    }
  }

  public static String composeBlastCommand(File blastPath, String command) {
    if (blastPath == null) {
      return Paths.get(command).toString();
    } else {
      return blastPath.toPath().resolve(command).toString();
    }
  }

  protected static void checkCommand(String command) throws BinaryCheckException {
    final Runtime runtime = Runtime.getRuntime();

    command += " -version";

    try {
      final Process process = runtime.exec(command);

      final BufferedReader br = new BufferedReader(
        new InputStreamReader(process.getInputStream())
      );

      StringBuilder sb = new StringBuilder();

      String line;
      int countLines = 0;
      while ((line = br.readLine()) != null) {
        sb.append(line).append('\n');
        countLines++;
      }

      if (countLines != 2) {
        throw new BinaryCheckException("Unrecognized version output", command);
      }

      final String[] lines = sb.toString().split("\n");

      if (!lines[1].trim().startsWith("Package")) {
        throw new BinaryCheckException("Unrecognized version output", command);
      }

      final int exitStatus = process.waitFor();
      if (exitStatus != 0) {
        throw new BinaryCheckException(
          "Invalid exit status: " + exitStatus,
          command
        );
      }
    } catch (IOException e) {
      throw new BinaryCheckException("Error while checking version", e, command);
    } catch (InterruptedException e) {
      throw new BinaryCheckException("Error while checking version", e, command);
    }
  }
}
