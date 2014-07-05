package com.greekadonis.gandas

class DataFrame extends LinkedHashMap<String, Object> {

  Set<String> getColumns() {
    keySet()
  }

  List<Object> getColumnValues(String column) {
    this[column]
  }

  /**
   * Print contents in tabular format, as seen in pandas
   */
  @Override
  String toString() {
    String msg = System.lineSeparator()
    //print columns
    getColumns().each {
      msg += "$it\t"
    }
    msg += System.lineSeparator()

    //just print row by row, for now
    Set<String> columns = getColumns()
    List<Object> firstColumn = getColumnValues(columns[0])
    int numRows = firstColumn.size()
    int numColumns = columns.size()

    (0..numRows-1).each { int row ->
      (0..numColumns-1).each { int col ->
        msg += "${getColumnValues(columns[col])[row]}\t"
      }
      msg += System.lineSeparator()
    }
    msg += "\t"
  }

  private String printRow() {

  }
}
