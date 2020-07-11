import java.util.Arrays;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        result[0] = findLeftBound(nums, target);
        result[1] = findRightBound(nums, target);
        return result;
    }

    private int findLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
         while (left + 1 < right) {
             int mid = left + (right - left) / 2;
             if (nums[mid] == target) {
                 right = mid;
             } else if (nums[mid] < target) {
                 left = mid + 1;
             } else {
                 right = mid - 1;
             }
         }
         if (nums[left] == target) {
             return left;
         } else if (nums[right] == target) {
             return right;
         } else {
             return -1;
         }
    }

    private int findRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(
                new int[]{5, 7, 7, 8, 8, 8, 8, 8 , 10}, 8)) + " === [3, 7]");
        System.out.println(Arrays.toString(searchRange.searchRange(
                new int[]{5, 7, 7, 7, 7, 8, 8, 8 , 10}, 8)) + " === [5, 7]");
        System.out.println(Arrays.toString(searchRange.searchRange(
                new int[]{5, 8, 8, 8, 8, 8, 8, 8 , 10}, 8)) + " === [1, 7]");
        System.out.println(Arrays.toString(searchRange.searchRange(
                new int[]{5, 7, 7, 7, 7, 9, 9, 9 , 10}, 8)) + " === [-1, -1]");
        System.out.println(Arrays.toString(searchRange.searchRange(
                new int[]{5, 7, 9, 9, 9, 9, 9, 9 , 10}, 8)) + " === [-1, -1]");
        System.out.println(Arrays.toString(searchRange.searchRange(
                new int[]{5, 7, 7, 7, 7, 7, 7, 8 , 10}, 8)) + " === [7, 7]");
        System.out.println(Arrays.toString(searchRange.searchRange(
                new int[]{5, 7, 8, 9, 9, 9, 9, 9 , 10}, 8)) + " === [2, 2]");
    }
}
