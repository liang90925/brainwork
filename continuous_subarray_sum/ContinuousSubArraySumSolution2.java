import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySumSolution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int numsLen = nums.length;
        if (numsLen <= 1) {
            return false;
        }
        int sum = 0;
        // Key stores the mod val over K
        Map<Integer, Integer> idxMap = new HashMap<>();
        // Put the (0, -1) so that it can be used to check sum
        idxMap.put(0, -1);

        for (int i = 0; i < numsLen; i++) {
            // get the sum first
            sum += nums[i];

            // get the mod value if k != 0;
            if (k != 0) {
                sum = sum % k;
            }
            // if the map contains the mod value, check the index
            // else put the new mod and index to the map
            if (idxMap.containsKey(sum)) {
                if (i - idxMap.get(sum) > 1) {
                    return true;
                }
            } else {
                idxMap.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubArraySumSolution2 solution = new ContinuousSubArraySumSolution2();

        System.out.println("=============");
        int k1 = 6;
        int[] nums1= new int[]{23, 2, 4, 6, 7};
        System.out.println("k: " + k1);
        System.out.println("nums: " + Arrays.toString(nums1));
        System.out.println(solution.checkSubarraySum(nums1, k1));

        System.out.println("=============");
        int k2 = 6;
        int[] nums2= new int[]{23, 2, 6, 4, 7};
        System.out.println("k: " + k2);
        System.out.println("nums: " + Arrays.toString(nums2));
        System.out.println(solution.checkSubarraySum(nums2, k2));

        System.out.println("=============");
        int k3 = 6;
        int[] nums3 = new int[]{23, 2, 6, 3, 5};
        System.out.println("k: " + k3);
        System.out.println("nums: " + Arrays.toString(nums3));
        System.out.println(solution.checkSubarraySum(nums3, k3));
    }
}
