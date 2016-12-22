// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator<T> implements Iterator<T> {
  private boolean hasPeeked;
  private T peekedElement;
  private Iterator<T> iterator;

  public PeekingIterator(Iterator<T> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    this.hasPeeked = false;
    this.peekedElement = null;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public T peek() {
    if (!hasPeeked) {
      peekedElement = iterator.next();
      hasPeeked = true;
    }
    return peekedElement;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public T next() {
    if (!hasPeeked) {
      return iterator.next();
    }
    T element = peekedElement;
    hasPeeked = false;
    peekedElement = null;
    return element;
  }

  @Override
  public boolean hasNext() {
    if (hasPeeked || iterator.hasNext()) {
      return true;
    }
    return false;
  }
}
