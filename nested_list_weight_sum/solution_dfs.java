/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

 //BFS`
public class Solution {
  public int depthSum(List<NestedInteger> nestedList) {
    if (nestedList == null || nestedList.size() == 0) {
      return 0;
    }

    Queue<NestedInteger> que = new LinkedList<>();
    for (NestedInteger ni : nestedList) {
      que.offer(ni);
    }

    int sum = 0, depth = 0;
    while (!que.isEmpty()) {
      int size = que.size();
      depth++;
      for (int i = 0; i < size; i++) {
        NestedInteger ni = que.poll();
        if (ni.isInteger()) {
          sum += ni.getInteger() * depth;
        } else {
          for (NestedInteger innerNi : ni.getList()) {
            que.offer(innerNi);
          }
        }
      }
    }
    return sum;
  }
}
