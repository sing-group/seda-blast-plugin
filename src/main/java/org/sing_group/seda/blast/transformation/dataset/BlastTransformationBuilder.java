package org.sing_group.seda.blast.transformation.dataset;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.sing_group.seda.blast.datatype.DatabaseQueryMode;
import org.sing_group.seda.blast.datatype.blast.BlastType;
import org.sing_group.seda.datatype.DatatypeFactory;
import org.sing_group.seda.transformation.TransformationException;

public class BlastTransformationBuilder {
  private BlastType blastType;
  private DatabaseQueryMode databaseQueryMode;
  private File queryFile;
  private double eValue = BlastTransformation.DEFAULT_EVALUE;
  private int maxTargetSeqs = BlastTransformation.DEFAULT_MAX_TARGET_SEQS;
  private File databasesDirectory = null;
  private File blastPath;
  private File aliasFile;
  private String blastAdditionalParameters = "";
  private DatatypeFactory factory = DatatypeFactory.getDefaultDatatypeFactory();
  private boolean extractOnlyHitRegions = BlastTransformation.DEFAULT_EXTRACT_ONLY_HIT_REGIONS;
  private int hitRegionsWindowSize = BlastTransformation.DEFAULT_HIT_REGIONS_WINDOW_SIZE;

  public BlastTransformationBuilder(BlastType blastType, File queryFile, DatabaseQueryMode databaseQueryMode) {
    this.blastType = blastType;
    this.queryFile = queryFile;
    this.databaseQueryMode = databaseQueryMode;
  }

  public BlastTransformationBuilder withEvalue(double eValue) {
    this.eValue = eValue;
    return this;
  }

  public BlastTransformationBuilder withMaxTargetSeqs(int maxTargetSeqs) {
    this.maxTargetSeqs = maxTargetSeqs;
    return this;
  }

  public BlastTransformationBuilder withDatabasesDirectory(File databasesDirectory) {
    this.databasesDirectory = databasesDirectory;
    return this;
  }

  public BlastTransformationBuilder withAliasFileDirectory(File aliasFile) {
    this.aliasFile = aliasFile;
    return this;
  }

  public BlastTransformationBuilder withBlastPath(File blastPath) {
    this.blastPath = blastPath;
    return this;
  }

  public BlastTransformationBuilder withBlastAditionalParameters(String blastAdditionalParameters) {
    this.blastAdditionalParameters = blastAdditionalParameters;
    return this;
  }

  public BlastTransformationBuilder withExtractOnlyHitRegions(boolean extractOnlyHitRegions) {
    this.extractOnlyHitRegions = extractOnlyHitRegions;
    return this;
  }

  public BlastTransformationBuilder withHitRegionsWindowSize(int hitRegionsWindowSize) {
    this.hitRegionsWindowSize = hitRegionsWindowSize;
    return this;
  }

  public BlastTransformationBuilder withDatatypeFactory(DatatypeFactory factory) {
    this.factory = factory;
    return this;
  }

  public BlastTransformation build() {
    try {
      if(getAliasFile().isPresent()) {
        return new BlastTransformation(
          blastType, databaseQueryMode,
          blastPath, queryFile,
          getDatabasesDirectory(),
          getAliasFile().get(),
          eValue, maxTargetSeqs,
          extractOnlyHitRegions, hitRegionsWindowSize,
          blastAdditionalParameters, factory
        );
      } else {
        return new BlastTransformation(
          blastType, databaseQueryMode,
          blastPath, queryFile,
          getDatabasesDirectory(),
          eValue, maxTargetSeqs,
          extractOnlyHitRegions, hitRegionsWindowSize,
          blastAdditionalParameters, factory
        );
      }
    } catch (IOException e) {
      throw new TransformationException(e);
    }
  }

  private File getDatabasesDirectory() throws IOException {
    return this.databasesDirectory == null
      ? Files.createTempDirectory("seda-blastdb").toFile()
      : this.databasesDirectory;
  }

  private Optional<File> getAliasFile() throws IOException {
    return Optional.ofNullable(this.aliasFile);
  }
}
