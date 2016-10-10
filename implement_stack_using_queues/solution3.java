// using one queue and one integer
// push -> O(n); pop -> O(1); top -> O(1);

class MyStack {
  private Queue<Integer> q = new LinkedList<>();
  private int top;
  // Push element x onto stack.
  public void push(int x) {
    q.offer(x);
    top = x;
    int size = q.size();
    while (size-- > 1) {
      q.offer(q.poll());
    }
  }

  // Removes the element on top of the stack.
  public void pop() {
    q.poll();
    if (!q.isEmpty()) {
      top = q.peek();
    }
  }

  // Get the top element.
  public int top() {
    return top;
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return q.isEmpty();
  }
}
