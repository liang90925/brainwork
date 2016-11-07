public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		int result = len + 1;
		int sum = 0;
		int j = 0;

		for (int i = 0; i < len; i++) {
			while (sum < s && j < len) {
				sum += nums[j++];
			}
			if (sum >= s) {
				result = result > (j - i) ? (j - i) : result;
				sum -= nums[i];
			}
		}

		return result == (len + 1) ? 0 : result;
	}
}
