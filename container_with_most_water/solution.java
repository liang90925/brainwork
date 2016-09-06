public class Solution {
  public int maxArea(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }
    int left = 0;
    int right = height.length -  1;
    int maxArea = 0;


    while (left < right) {
      int min = Math.min(height[left], height[right]);
      int currArea = (right - left) * min;
      maxArea = Math.max(currArea, maxArea);
      if (height[left] < height[right]) {
        left++;
      } else if (height[left] > height[right]) {
        right--;
      } else {
        left++;
        right--;
      }
    }

    return maxArea;
  }
}
