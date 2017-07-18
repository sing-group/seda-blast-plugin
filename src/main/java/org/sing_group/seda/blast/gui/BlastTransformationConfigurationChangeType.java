package org.sing_group.seda.blast.gui;

import org.sing_group.seda.plugin.spi.TransformationChangeType;

public enum BlastTransformationConfigurationChangeType implements TransformationChangeType {
  BLAST_PATH_CHANGED, 
  STORE_DATABASES_CHANGED, 
  DATABASES_DIRECTORY_CHANGED, 
  STORE_ALIAS_CHANGED, 
  ALIAS_FILE_CHANGED, 
  BLAST_TYPE_CHANGED, 
  QUERY_FILE_CHANGED, 
  E_VALUE_CHANGED, 
  MAX_TARGET_SEQS_CHANGED, 
  BLAST_ADDITONAL_PARAMETERS_CHANGED, 
  EXTRACT_ONLY_HIT_REGIONS_CHANGED, 
  HIT_REGIONS_WINDOW_SIZE_CHANGED
}
