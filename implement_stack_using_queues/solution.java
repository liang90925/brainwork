// using two queues
// push -> O(n); pop -> O(1); top -> O(1);

class MyStack {

  private Queue<Integer> q1 = new LinkedList<>();
  private Queue<Integer> q2 = new LinkedList<>();

  // Push element x onto stack.
  public void push(int x) {
    q2.offer(x);
    while (!q1.isEmpty()) {
      q2.offer(q1.poll());
    }
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;
  }

  // Removes the element on top of the stack.
  public void pop() {
    if (!q1.isEmpty()) {
      q1.poll();
    }
  }

  // Get the top element.
  public int top() {
    if (!q1.isEmpty()) {
      return q1.peek();
    }
    return -1;
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return q1.isEmpty();
  }
}
