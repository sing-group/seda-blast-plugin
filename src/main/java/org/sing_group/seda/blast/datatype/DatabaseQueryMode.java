package org.sing_group.seda.blast.datatype;

public enum DatabaseQueryMode {
  ALL("All databases"), EACH("Each database separately");

  private String description;

  DatabaseQueryMode(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return this.description;
  }
}
