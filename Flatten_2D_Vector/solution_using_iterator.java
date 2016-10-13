public class Vector2D implements Iterator<Integer> {
  private Iterator<Integer> intItr = null;
  private Iterator<List<Integer>> intListItr = null;

  public Vector2D(List<List<Integer>> vec2D) {
    intListItr = vec2D.iterator();
    // to check whether the input vec2D is an empty list;
    if (intListItr.hasNext()) {
      intItr = intListItr.next().iterator();
    }
  }

  @Override
  public Integer next() {
    if (hasNext()) {
      return intItr.next();
    }
    return -1;
  }

  @Override
  public boolean hasNext() {
    // check the empty input vec2D list first
    if (intItr == null ) {
        return false;
    }
    if (intItr.hasNext()) {
      return true;
    }
    while (intListItr.hasNext()) {
      intItr = intListItr.next().iterator();
      if (intItr.hasNext()) {
        return true;
      }
    }
    return false;
  }

  public void remove() {
    intItr.remove();
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
