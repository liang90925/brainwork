
public class TwoDVector {
  private Iterator<List<Integer>> row = null;
  private Iterator<Integer> col = null;

  public TwoDVector (List<List<Integer>> 2dVector) {
    row = 2dVector.iterator();
    if (row.hasNext()) {
      col = row.next().iterator();
    }
  }

  public int next() {
    int nextValue = col.next();
    return nextValue;
  }

  public boolean hasNext() {
    if (col == null) {
      return false;
    }
    if (col.hasNext()) {
      return true;
    } else {
      while (row.hasNext()) {
        col = row.next().iterator();
        if (col.hasNext()) {
          return true;
        }
      }
      return false;
    }
  }

  public void remove() {
    col.remove();
  }

  public void main (String[] args) {
    
  }
}
