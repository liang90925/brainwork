import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
    }

    public void push(int x) {
      stack.push(x);
      if (minStack.isEmpty() || x <= minStack.peek()) {
        minStack.push(x);
      }
    }

    public void pop() {
      if (stack.isEmpty()) {
        return;
      }

      if (stack.peek().equals(minStack.peek())) {
        minStack.pop();
      }
      stack.pop();
    }

    public int top() {
      if(!stack.isEmpty()) {
        return stack.peek();
      }
      return 0;
    }

    public int getMin() {
      if(!minStack.isEmpty()) {
        return minStack.peek();
      }
      return 0;
    }
}
