public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    // two levels of for/while loop;
    // loop through to select a first element;
    // and then loop through the rest for other two elements just like 2sum
    // two things need to be taken care;
    // 1. sort the input nums
    // 2. take care of the duplicate numbers (skip them)

    List<List<Integer>> result = new ArrayList<>();

    int lth = nums.length;
    if (nums == null || lth < 3) { return result; }

    Arrays.sort(nums);
    for (int i = 0; i < lth - 2; i++) {
      if (i != 0 && nums[i] == nums[i-1]) {
        continue;
      }
      int left = i + 1;
      int right = lth - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
          while (left < right && nums[left] == nums[left - 1]) { left++; }
          while (left < right && nums[right] == nums[right + 1]) { right--; }
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }
}
