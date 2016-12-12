import java.util.*;

public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    int len = nums.length;
    if (len ==  0) {
      result.add(new ArrayList<>());
      return result;
    }

    List<Integer> single = new ArrayList<>();
    boolean[] visited = new boolean[len];

    // NOTE: 别忘了先sort array！！！
    Arrays.sort(nums);
    dfs(nums, single, result, visited);
    return result;
  }

  private void dfs(int[] nums, List<Integer> single, List<List<Integer>> result, boolean[] visited) {
    if (single.size() == nums.length) {
      result.add(new ArrayList<>(single));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // NOTE: 此处是题目的精髓，注意是!visited[i -1]啊！
      /* 解释
      上面的判断主要是为了去除重复元素影响。
      比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
      我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
      当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
      不应该让后面的2使用。
      */
      if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i -1])) {
        continue;
      }

      single.add(nums[i]);
      visited[i] = true;
      dfs(nums, single, result, visited);
      single.remove(single.size() - 1);
      visited[i] = false;
    }
  }
}
