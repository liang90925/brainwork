import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsKSolution2 {
    // Using Map O(N) O(N)
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int numsLen = nums.length;
        for (int i = 0; i < numsLen; i++) {
            int sum = 0;
            for (int j = i; j < numsLen; j++) {
                sum += nums[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        SubArraySumEqualsKSolution2 solution = new SubArraySumEqualsKSolution2();

        System.out.println("=============");
        int k1 = 2;
        int[] nums1= new int[]{1, 1, 1};
        System.out.println("k: " + k1);
        System.out.println("nums: " + Arrays.toString(nums1));
        System.out.println(solution.subarraySum(nums1, k1));

        System.out.println("=============");
        int k2 = 5;
        int[] nums2= new int[]{1, 2, 2, 3, 2, 4 ,1};
        System.out.println("k: " + k2);
        System.out.println("nums: " + Arrays.toString(nums2));
        System.out.println(solution.subarraySum(nums2, k2));

        System.out.println("=============");
        int k3 = 0;
        int[] nums3 = new int[]{-1, -1, 1};
        System.out.println("k: " + k3);
        System.out.println("nums: " + Arrays.toString(nums3));
        System.out.println(solution.subarraySum(nums3, k3));
    }
}
