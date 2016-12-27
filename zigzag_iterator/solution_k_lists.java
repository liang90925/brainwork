public class ZigzagIterator {
  private Queue<Iterator<Integer>> itrQue;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    itrQue = new LinkedList<>();
    if (!v1.isEmpty()) {
      itrQue.offer(v1.iterator());
    }
    if (!v2.isEmpty()) {
      itrQue.offer(v2.iterator());
    }
  }

  public int next() {
    Iterator<Integer> currItr = itrQue.poll();
    int result = currItr.next();
    if (currItr.hasNext()) {
      itrQue.offer(currItr);
    }
    return result;
  }

  public boolean hasNext() {
    return !itrQue.isEmpty();
  }

}
