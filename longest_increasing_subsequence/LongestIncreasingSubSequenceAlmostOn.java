
class LongestIncreasingSubSequenceAlmostOn {
  /**
   * @param nums: An integer array
   * @return: The length of LIS (longest increasing subsequence)
   */
  public int longestIncreasingSubsequence(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    int len = nums.length;

    for (int i = 0; i < len; i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    for (int num : nums) {
      int j = firstBiggest(dp, num);
      dp[j] = num;
    }

    for (int i = 0; i < nums.length; i++) {
      if (dp[i] == Integer.MAX_VALUE) {
        return i == 0 ? 1 : i;
      }
    }
    return len;
  }

  // Use Binary Search to find the first biggestvale
  private int firstBiggest(int[] dp, int num) {
    for (int j = 0; j < dp.length; j++) {
      if (num <= dp[j]) {
        return j;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    LongestIncreasingSubSequenceAlmostOn solution = new LongestIncreasingSubSequenceAlmostOn();
    System.out.println(solution.longestIncreasingSubsequence(new int[]{9,3,6,2,7}));
  }
}
