import java.util.Arrays;

public class ContinuousSubArraySumSolution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int numsLen = nums.length;
        if (numsLen <= 1) {
            return false;
        }

        for (int i = 0; i < numsLen - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < numsLen; j++) {
                sum += nums[j];
                if (k == 0 && sum == 0) {
                    return true;
                }
                if (k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubArraySumSolution solution = new ContinuousSubArraySumSolution();

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
