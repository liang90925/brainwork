// non-recursive version
public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    // pre check
    if (nums == null || nums.length == 0) {
      return result;
    }
    Arrays.sort(nums);
    int n = nums.length;

    // 1 << n equals to 2^n
    // each subset equals an binary integer 0 to 2^n - 1
    // 0 -> 000 -> []
    // 1 -> 001 -> [1]
    // 2 -> 010 -> [2]
    // 3 -> 011 -> [1,2]
    // 4 -> 100 -> [3]
    // 5 -> 101 -> [1,3]
    // 6 -> 110 -> [2,3]
    // 7 -> 111 -> [1,2,3]

    for (int i = 0; i < (1 << n); i++) {
      List<Integer> singleSet = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          singleSet.add(nums[j]);
        }
      }
      result.add(singleSet);
    }
    return result;
  }
}
