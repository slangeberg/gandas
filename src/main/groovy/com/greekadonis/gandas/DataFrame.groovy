package com.greekadonis.gandas

class DataFrame  {

  private LinkedHashMap<String, Object> data

  //Expando impl - allows direct access to data
  // ex:
  // println df.age

  def getProperty(String name) { data[name] }

  //void setProperty(String name, value) { data[name] = value }

  public DataFrame(Map<String, Object> params){
    data = params
  }


  /**
   * Basically a row getter
   * @return Row data as Map, found at 0-indexed 'row'
   */
  Map loc(int row){
    Map<String, Object> result = new LinkedHashMap<String, Object>()
    Set<String> columns = getColumns()
    Object val  = null
    columns.each { String col ->
      val = getColumnValues(col)[row]
      result.put(col, val)
    }
    result
  }

  Set<String> getColumns() {
    data.keySet()
  }

  List<Object> getColumnValues(String column) {
    data[column]
  }

  /**
   * Print contents in tabular format, as seen in pandas
   */
  @Override
  String toString() {
    String msg = System.lineSeparator()
    //print columns
    Set<String> columns = getColumns()
    columns.each {
      msg += "$it\t"
    }
    msg += System.lineSeparator()

    //just print row by row, for now
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
