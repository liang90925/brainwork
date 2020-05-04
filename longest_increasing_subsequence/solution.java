
class solution {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = 0;

    int[] dp = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      // init dp[i] here can be simpler
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        // 注意这里的条件
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
