import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsKSolution {
    // Using Map O(N) O(N)
    public int subarraySum(int[] nums, int k) {
        int numsLen = nums.length;
        if (numsLen == 1) {
            return nums[0] == k ? 1 : 0;
        }
        Map<Integer, Integer> sumMap = new HashMap<>();

        sumMap.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) {
                cnt += sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);

        }
        return cnt;
    }

    public static void main(String[] args) {
        SubArraySumEqualsKSolution solution = new SubArraySumEqualsKSolution();

//        System.out.println("=============");
//        int k1 = 2;
//        int[] nums1= new int[]{1, 1, 1};
//        System.out.println("k: " + k1);
//        System.out.println("nums: " + Arrays.toString(nums1));
//        System.out.println(solution.subarraySum(nums1, k1));
//
//        System.out.println("=============");
//        int k2 = 5;
//        int[] nums2= new int[]{1, 2, 2, 3, 2, 4 ,1};
//        System.out.println("k: " + k2);
//        System.out.println("nums: " + Arrays.toString(nums2));
//        System.out.println(solution.subarraySum(nums2, k2));

        System.out.println("=============");
        int k3 = 0;
        int[] nums3 = new int[]{-1, -1, 1};
        System.out.println("k: " + k3);
        System.out.println("nums: " + Arrays.toString(nums3));
        System.out.println(solution.subarraySum(nums3, k3));
    }
}
