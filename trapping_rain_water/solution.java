public class Solution {
  public int trap(int[] height) {
    if (height == null || height.length < 3) {
      return 0;
    }

    int lth = height.length;
    int[] leftMax = new int[lth + 1];

    leftMax[0] = 0;
    for (int i = 0; i < lth; i++) {
      leftMax[i + 1] = Math.max(leftMax[i], height[i]);
    }

    int rightMax = 0, area = 0;

    for (int i = lth - 1; i >= 0; i--) {
      area += Math.min(rightMax, leftMax[i]) > height[i] ?
      Math.min(rightMax, leftMax[i]) - height[i] : 0;

      rightMax = Math.max(rightMax, height[i]);
    }

    return area;
  }
}
