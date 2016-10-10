// two stacks
// push On; pop O1; peek O1;

class MyQueue {

  private Stack<Integer> s1;
  private Stack<Integer> s2;

  public MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }
//////////////////////////////
  private void stackTransfer(Stack<Integer> s1, Stack<Integer> s2) {
    while(!s1.empty()) {
      s2.push(s1.pop());
    }
  }

  // Push element x to the back of queue.
  public void push(int x) {
    stackTransfer(s1, s2);
    s1.push(x);
    stackTransfer(s2, s1);
  }
///////////////////////////////
//OR
  public void push(int x) {
    while(!s1.empty()) {
      s2.push(s1.pop());
    }
    s1.push(x);
    while(!s2.empty()) {
      s1.push(s2.pop());
    }
  }
///////////////////////////////

  // Removes the element from in front of queue.
  public void pop() {
    if (!s1.empty()) {
      s1.pop();
    }
  }

  // Get the front element.
  public int peek() {
    if (!s1.empty()) {
      return s1.peek();
    }
    return -1;
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return s1.empty();
  }
}
