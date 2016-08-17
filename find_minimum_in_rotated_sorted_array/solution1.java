// solution1: enumeration O(n)
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int smallest = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < smallest) {
                smallest = nums[i];
                break;
            }
        }
        return smallest;
    }
}
