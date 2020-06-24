import java.util.List;

public class MaximumSubArrayII {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int len = nums.size();

        int[] leftMaxArray = new int[len];
        int leftSum = Math.max(0, nums.get(0));
        leftMaxArray[0] = nums.get(0);
        for (int i = 1; i < len; i++) {
            leftSum += nums.get(i);
            leftMaxArray[i] = Math.max(leftSum, leftMaxArray[i-1]);
            leftSum = Math.max(0, leftSum);
        }

        int[] rightMaxArray = new int[len];
        int rightSum = Math.max(0, nums.get(len - 1));
        rightMaxArray[len - 1] = nums.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            rightSum += nums.get(i);
            rightMaxArray[i] = Math.max(rightSum, rightMaxArray[i + 1]);
            rightSum = Math.max(0, rightSum);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, leftMaxArray[i] + rightMaxArray[i + 1]);
        }
        return max;
    }
}
