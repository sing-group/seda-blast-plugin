package org.sing_group.seda.blast.datatype.blast;

public class BlastEnvironment {

  private static BlastEnvironment INSTANCE;

  public static BlastEnvironment getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new BlastEnvironment();
    }
    return INSTANCE;
  }

  public String getMakeBlastDbCommand() {
    return "makeblastdb";
  }

  public String getBlastDbAliasToolCommand() {
    return "blastdb_aliastool";
  }

  public String getBlastDbCmdCommand() {
    return "blastdbcmd";
  }

  public String getBlastCommand(BlastType blastType) {
    return blastType.name().toLowerCase();
  }
}