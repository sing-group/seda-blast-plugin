package org.sing_group.seda.blast.datatype;

import org.sing_group.seda.util.StringUtils;

public enum SequenceType {
	NUCLEOTIDES("nucl"), PROTEINS("prot");
  
  private final String blastName;
  
  private SequenceType(String blastName) {
    this.blastName = blastName;
  }
  
  public String getBlastName() {
    return blastName;
  }
  
  @Override
  public String toString() {
    return StringUtils.capitalize(super.toString());
  }
}
