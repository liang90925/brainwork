import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsKSolutionII {
    // NOTE: don't forget the -1 case
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the minimum length of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsKII(int[] nums, int k) {
        // write your code here

        // write your code here
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int sum = 0;
        int min = len + 1;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            int target = sum - k;
            if (sumMap.containsKey(target)) {
                int subLen = i - sumMap.get(target);
                min = Math.min(min, subLen);
            }
            sumMap.put(sum, i);
        }
        return min == len+1 ? -1: min;
    }
}
