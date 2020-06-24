public class MaximumSubArrayDifferenceAnother {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        int[] leftMaxArray = new int[len];
        int[] rightMaxArray = new int[len];
        int[] leftMinArray = new int[len];
        int[] rightMinArray = new int[len];

        int leftSum = Math.max(0, nums[0]);
        leftMaxArray[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftSum += nums[i];
            leftMaxArray[i] = Math.max(leftSum, leftMaxArray[i-1]);
            leftSum = Math.max(0, leftSum);
        }

        int[] copy = new int[len];
        for(int i = 0; i < len; i++){
            copy[i] = -1 * nums[i];
        }

        int rightSum = Math.max(0, nums[len - 1]);
        rightMaxArray[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightSum += nums[i];
            rightMaxArray[i] = Math.max(rightSum, rightMaxArray[i + 1]);
            rightSum = Math.max(0, rightSum);
        }

        leftSum = Math.max(0, copy[0]);
        leftMinArray[0] = copy[0];
        for (int i = 1; i < len; i++) {
            leftSum += copy[i];
            leftMinArray[i] = Math.max(leftSum, leftMinArray[i-1]);
            leftSum = Math.max(0, leftSum);
        }
        for (int i = 0; i < len; i++) {
            leftMinArray[i] = -1 * leftMinArray[i];
        }

        rightSum = Math.max(0, copy[len - 1]);
        rightMinArray[len - 1] = copy[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightSum += copy[i];
            rightMinArray[i] = Math.max(rightSum, rightMinArray[i + 1]);
            rightSum = Math.max(0, rightSum);
        }
        for (int i = 0; i < len; i++) {
            rightMinArray[i] = -1 * rightMinArray[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i ++) {
            int max1 = Math.abs(leftMaxArray[i] - rightMinArray[i + 1]);
            int max2 = Math.abs(rightMaxArray[i + 1] - leftMinArray[i]);
            max = Math.max(max, Math.max(max1, max2));

        }
        return max;
    }
}
