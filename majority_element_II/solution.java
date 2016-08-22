public class Solution {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    int count1 = 0, count2 = 0;
    int target1 = 0, target2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target1) {
        count1++;
      } else if (nums[i] == target2) {
        count2++;
      } else if (count1 == 0) {
        target1 = nums[i];
        count1 = 1;
      } else if (count2 == 0) {
        target2 = nums[i];
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    count1 = count2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target1) {
        count1++;
      }
      if (nums[i] == target2) {
        count2++;
      }
    }
    if (count1 > nums.length/3) {
       result.add(target1);
    }
    if (count2 > nums.length/3 && !result.contains(target2)) {
       result.add(target2);
    }
    return result;
  }
}
