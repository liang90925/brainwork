public class ZigzagIterator {

  private boolean atV1;
  private int index1;
  private int index2;
  private List<Integer> v1;
  private List<Integer> v2;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    this.atV1 = (v1 != null && v1.size() > 0) ? true : false;
    this.index1 = 0;
    this.index2 = 0;
    this.v1 = v1;
    this.v2 = v2;
  }

  public int next() {
    int value;
    if (atV1) {
      value = v1.get(index1++);
    } else {
      value = v2.get(index2++);
    }
    atV1 = !atV1;
    return value;
  }

  public boolean hasNext() {
    if (atV1) {
      if (index1 < v1.size()) {
        return true;
      }
      atV1 = !atV1;
      if (index2 < v2.size()) {
        return true;
      } else {
        return false;
      }
    } else {
      if (index2 < v2.size()) {
        return true;
      }
      atV1 = !atV1;
      if (index1 < v1.size()) {
        return true;
      } else {
        return false;
      }
    }
  }
}


/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
