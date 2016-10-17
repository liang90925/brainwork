/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
  public NestedInteger deserialize(String s) {
    if (s == null) {
      return null;
    }

    // return a NestedInteger with the num value
    if (s.charAt(0) != '[') {
      return new NestedInteger(Integer.valueOf(s));
    }

    Stack<NestedInteger> stack = new Stack<>();
    StringBuilder num = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case '[':
          // push an empty NestedInteger
          stack.push(new NestedInteger());
          break;

        case ',':
          // if there is a num, create a NestedInteger with the value and add to the previous NestedInteger
          if (num.length() > 0) {
            stack.peek().add(new NestedInteger(Integer.valueOf(num.toString())));
            num.setLength(0);
          }
          break;

        case ']':
          // if there is a num, create a NestedInteger with the value and add to the previous NestedInteger
          if (num.length() > 0) {
            stack.peek().add(new NestedInteger(Integer.valueOf(num.toString())));
            num.setLength(0);
          }
          // pop the stack to get the current completed NestedInteger;
          NestedInteger currNi = stack.pop();

          // if there are still NestedInteger in the stack, add the current NestedInteger to previous one
          // or return the currNi, since it's the last ];
          if (!stack.isEmpty()) {
            stack.peek().add(currNi);
          } else {
            return currNi;
          }
          break;
        // default to build the number;
        default:
          num.append(s.charAt(i));
          break;
      }
    }
    return null;
  }
}
