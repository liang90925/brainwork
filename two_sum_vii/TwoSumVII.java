import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumVII {
    /**
     * @param nums: the input array
     * @param target: the target number
     * @return: return the target pair
     */
    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        // write your code here

        int numsLen = nums.length;

        if (nums.length < 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> results = new ArrayList<>();

        int left = 0;
        int right = 0;

        // Find the biggest and smallest value from this array
        for (int i = 1; i < numsLen; i++) {
            if (nums[i] > nums[right]) {
                right = i;
            }
            if (nums[i] < nums[left]) {
                left = i;
            }
        }

        // go over the array with two pointers at left and right and check the sum comparing to the target
        // and move the two pointers according to the value
        while (nums[left] < nums[right]) {
            // need to move left to a bigger value
            if (nums[left] + nums[right] < target) {
                left = nextBiggerLeft(nums, left);
                if (left == -1) {
                    break;
                }
            } else if (nums[left] + nums[right] > target) {
                // need to move right to a smaller value
                right = nextSmallerRight(nums, right);
                if (right == -1) {
                    break;
                }
            } else {
                List<Integer> foundOne = new ArrayList<>();
                if (left < right) {
                    foundOne.add(left);
                    foundOne.add(right);
                } else if (left > right){
                    foundOne.add(right);
                    foundOne.add(left);
                }
                results.add(foundOne);
                left = nextBiggerLeft(nums, left);
                if (left == -1) {
                    break;
                }
            }
        }
        return results;
    }

    private int nextBiggerLeft(int[] nums, int currIdx) {
        if(nums[currIdx] < 0) {
            for (int i = currIdx - 1; i >=0; i--) {
                if (nums[i] < 0) {
                    return i;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    return i;
                }
            }
            return -1;
        }

        // when nums[currIdx] >= 0
        for (int i = currIdx + 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i;
            }
        }
        return -1;
    }

    private int nextSmallerRight(int[] nums, int currIdx) {
        if (nums[currIdx] > 0) {
            for (int i = currIdx - 1; i >= 0; i--) {
                if (nums[i] > 0) return i;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0) return i;
            }
            return -1;
        }

        // when nums[currIdx] <= 0
        for (int i = currIdx + 1; i < nums.length; i++) {
            if (nums[i] <= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TwoSumVII solution = new TwoSumVII();
        System.out.print(solution.twoSumVII(new int[]{0,1,2,3,4,5,6,7,8,9,10}, 8));
        System.out.println("should equal to [0,8],[1,7],[2,6],[3,5]");
        System.out.println(solution.twoSumVII(new int[]{0,-1,2,-3,4}, 1) + "should equal to [3, 4], [1, 2]");
    }
}
