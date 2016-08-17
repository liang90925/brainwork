public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 1;
        int tempResult = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            if (nums[j] == nums[i]) { continue;}
            else if (nums[j] == nums[i] + 1) {
                tempResult++;
                continue;
            } else {
                result = Math.max(tempResult, result);
                tempResult = 1;
            }
        }
        return Math.max(tempResult, result);
    }
}
