import java.util.Arrays;

class LongestIncreasingSubSequenceBinaryRewrite {
  /**
   * @param nums: An integer array
   * @return: The length of LIS (longest increasing subsequence)
   */
  public int longestIncreasingSubsequence(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int len = nums.length;
    int[] minLast = new int[len + 1];
    minLast[0] = Integer.MIN_VALUE;

    for (int i = 1; i < len; i++) {
      minLast[i] = Integer.MAX_VALUE;
    }

    for (int num : nums) {
      int j = firstBiggest(minLast, num);
      minLast[j] = num;
    }

    for (int i = 0; i < nums.length; i++) {
      if (minLast[i] == Integer.MAX_VALUE) {
        return i - 1;
      }
    }
    return len;
  }

  // Use Binary Search to find the first biggestvale
  private int firstBiggest(int[] minLast, int num) {
    int start = 0;
    int end = minLast.length - 1;

    while (start < end - 1) {
      int mid = (end - start) / 2 + start;
      if (minLast[mid] < num) {
        start = mid;
      } else {
        end = mid;
      }
    }

    return end;
  }

  public static void main(String[] args) {
    LongestIncreasingSubSequenceBinaryRewrite solution = new LongestIncreasingSubSequenceBinaryRewrite();
    System.out.println(solution.longestIncreasingSubsequence(new int[]{9,3,6,2,7}));
  }
}
