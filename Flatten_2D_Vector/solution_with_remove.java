public class Vector2D implements Iterator<Integer> {
  private List<List<Integer>> array;
  private int rowId;
  private int colId;


  public Vector2D(List<List<Integer>> vec2D) {
    this.array = vec2D;
    this.rowId = 0;
    this.colId = 0;
  }

  @Override
  public Integer next() {
    System.out.println(array);
    if (hasNext()) {
      return array.get(rowId).get(colId++);
    }
    return -1;
  }

  @Override
  public boolean hasNext() {
    if (rowId >= array.size()) {
      return false;
    }
    if (colId < array.get(rowId).size()) {
      return true;
    }

    while (++rowId < array.size()) {
      if (!array.get(rowId).isEmpty()) {
        colId = 0;
        return true;
      }
    }
    return false;
  }

  @Override
  public void remove() {
    List<Integer> listToRemove = new ArrayList<>();
    //int rowToRemove;
    int colToRemove;

    // the next() function returned the last element of current list;

    listToRemove = array.get(rowId);
    colToRemove = colId - 1;
    listToRemove.remove(colToRemove);



    if (listToRemove.isEmpty()) {
      array.remove(listToRemove);
      if (rowId != 0) {
        rowId--;
      }
    }
    colId--;
    System.out.println(array);
  }

  public static void main(String[] args) {
    List<Integer> row0 = new ArrayList<>();
    List<Integer> row01 = new ArrayList<>();
    List<Integer> row1 = new ArrayList<>();
    row1.add(1);
    row1.add(2);
    row1.add(3);
    List<Integer> row2 = new ArrayList<>();
    row2.add(4);
    row2.add(5);
    List<Integer> row21 = new ArrayList<>();
    List<Integer> row3 = new ArrayList<>();
    row3.add(6);
    List<Integer> row4 = new ArrayList<>();
    List<Integer> row5 = new ArrayList<>();

    List<List<Integer>> vec2D = new ArrayList<>();
    vec2D.add(row0);
    vec2D.add(row01);
    vec2D.add(row1);
    vec2D.add(row2);
    vec2D.add(row21);
    vec2D.add(row3);
    vec2D.add(row4);
    vec2D.add(row5);

    Vector2D v2d = new Vector2D(vec2D);

    while (v2d.hasNext()) {
      int result = v2d.next();
      System.out.println(result);
     v2d.remove();
    }
  }
}
