public class KthLargestElementInAnArray {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (k <= 0) {
      return 0;
    }
    return quickSelect(nums, 0, nums.length-1, nums.length - k);
  }

  // quickSelect 是一个 n + n/2 + n/4.... O(2n),平摊下来就是O(N)
  public int quickSelect(int[] nums, int left, int right, int k){
    if(left == right) {
      return nums[left];
    }

    int position = partition(nums, left, right);

    if (position == k) {
      return nums[position];
    } else if(position < k) {
      return quickSelect(nums, position + 1, right, k);
    } else {
      return quickSelect(nums, left, position - 1, k);
    }
  }

  // Partition 这部分的复杂度是O(n)
  public int partition(int[] nums, int left, int right) {
    int pivot = nums[left];
    while(left < right) {
      while(left < right && nums[right] >= pivot) {
        right--;
      }
      nums[left] = nums[right];
      while(left < right && nums[left] <= pivot) {
        left++;
      }
      nums[right] = nums[left];
    }
    nums[left] = pivot;
    return left;
  }
}
