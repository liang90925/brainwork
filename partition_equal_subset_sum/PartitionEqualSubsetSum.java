public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        // write your code here
        int len = nums.length;
        int max = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if (sum % 2 != 0) {
            return false;
        }

        int halfSum = sum / 2;
        if (max > halfSum) {
            return false;
        }

        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;
        for (int num: nums) {
            for (int i = halfSum; i >= num; i--) {
                dp[i] = dp[i] || dp [i - num];
            }
        }
        return dp[halfSum];
    }
}
