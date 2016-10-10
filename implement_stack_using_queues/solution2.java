// using one queue
// push -> O(1); pop -> O(n); top -> O(n);

class MyStack {
  private Queue<Integer> q = new LinkedList<>();

  // Push element x onto stack.
  public void push(int x) {
    q.offer(x);
  }

  // Removes the element on top of the stack.
  public void pop() {
    int size = q.size();
    while (size-- > 1) {
      q.offer(q.poll());
    }
    q.poll();
  }

  // Get the top element.
  public int top() {
    int size = q.size();
    while (size-- > 1) {
      q.offer(q.poll());
    }
    int val = q.peek();
    q.offer(q.poll());
    return val;
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return q.isEmpty();
  }
}
