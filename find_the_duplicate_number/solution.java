public class Solution {
  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }
    int left = 0;
    int right = nums.length;
    while (left < right) {
      int mid = (left + right) / 2;
      int smallNumCount = getSmallNumCount(nums, mid);
      if (smallNumCount <= mid) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  private int getSmallNumCount(int[] nums, int mid) {
    return (int) Arrays.stream(nums).filter(num -> num <= mid).count();
  }
}
