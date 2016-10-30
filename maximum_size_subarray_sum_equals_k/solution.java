// Use HashMap to store the sum value from 0 to i as key and i as value;
// along the way, at each i  we check every (sum - k) at the index,
// if map contains (sum -k) as the key, that means from key-1 to i can add up to K
// we than compare the value of max and i - map.get(sum-k) and assign to max;
// time complexity O(n)
// space complexity O(n)

public class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    // when sum = 0, suppose at the head of the nums will get the larger indx diff
    map.put(0, -1);

    // sum to store sum value at each index
    int sum = 0;

    // max to track the max value and return as result
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
      if (map.containsKey(sum - k)) {
        int index = map.get(sum - k);
        max = Math.max(max, i - index);
      }
    }
    // NOTE: !!!if max is still MIN_VALUE, there could not find numbers add up to k, so return 0
    return max == Integer.MIN_VALUE ? 0 : max;
  }
}
