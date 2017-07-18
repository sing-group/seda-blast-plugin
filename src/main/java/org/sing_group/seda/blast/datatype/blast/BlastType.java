package org.sing_group.seda.blast.datatype.blast;

import org.sing_group.seda.blast.datatype.SequenceType;

public enum BlastType {
  BLASTN(SequenceType.NUCLEOTIDES), 
  BLASTP(SequenceType.PROTEINS), 
  BLASTX(SequenceType.PROTEINS), 
  TBLASTX(SequenceType.NUCLEOTIDES), 
  TBLASTN(SequenceType.NUCLEOTIDES);

  private SequenceType databaseType;

  BlastType(SequenceType dbType) {
    this.databaseType = dbType;
  }

  public String getCommand() {
    return BlastEnvironment.getInstance().getBlastCommand(this);
  }

  public SequenceType getDatabaseType() {
    return databaseType;
  }

  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
}
