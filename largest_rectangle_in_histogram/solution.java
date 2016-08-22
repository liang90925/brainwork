public class Solution {
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length < 0) {
      return 0;
    }

    int h = 0, w = 0;
    int max = 0;
    Stack<Integer> indexStack = new Stack<>();
    for (int i = 0; i <= heights.length; i++) {
      int curr = i == heights.length ? -1 : heights[i];
      while (!indexStack.isEmpty() && curr <= heights[indexStack.peek()]) {
        h = heights[indexStack.pop()];
        w = indexStack.isEmpty() ? i : i - indexStack.peek() - 1;
        max = Math.max(max, h * w);
      }
      indexStack.push(i);
    }
    return max;
  }
}
