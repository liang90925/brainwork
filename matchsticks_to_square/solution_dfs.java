public class Solution {
  public boolean makesquare(int[] nums) {
    if (nums == null || nums.length < 4) {
      return false;
    }
    // get the total value of nums
    int total = Arrays.stream(nums).sum();
    if (total % 4 != 0) {
      return false;
    }

    int len = nums.length;
    // sort the nums input with decending order
    Arrays.sort(nums);
    for ( int i = 0; i < len / 2; i++) {
        int temp = nums[i];
        nums[i] = nums[len - i - 1];
        nums[len - i - 1] = temp;
    }

    int edgeLen = total / 4;
    if (nums[0] > edgeLen) {
      return false;
    }

    return dfs(nums, new int[4], 0, edgeLen);
  }

  private boolean dfs(int[] nums, int[] square, int index, int edgeLen) {
    if (index == nums.length) {
      return true;
    }
    for (int i = 0; i < 4; i++) {
      if (square[i] + nums[index] > edgeLen) continue;
      if (index < 4 && i > index) break; //理解这段话： 深度优先搜索，由于要对数字进行分组，而组号并不重要，重要的是区分不同组就行，所以增加一行剪枝“if(step < 4 && i > step) break”可以极大缩短搜索时间。
      square[i] += nums[index];
      if (dfs(nums, square, index + 1, edgeLen)) {
        return true;
      }
      square[i] -= nums[index];
    }
    return false;
  }
}
