public class SolutionNewTry {
  public int findKthLargest(int[] nums, int k) {
    int numLen = nums.length;
    // kth largest means the numLen - k + 1 sorted in ascending order
    quickSort(nums, 0, numLen - 1, numLen - k + 1);
    return nums[numLen - k];
  }
  public void quickSort(int[] nums, int left, int right, int k) {
    if (left == right) {
      return;
    }

    // find the pivot
    int pivot = partition(nums, left, right);

    // keep going to quicksort in different cases
    int leftLen = pivot - left + 1;
    if (leftLen == k) {
      return;
    }
    if (leftLen < k) {
      quickSort(nums, pivot + 1, right, k - leftLen);
    }
    if (leftLen > k) {
      quickSort(nums, left, pivot - 1, k);
    }
  }

  public int partition(int[] nums, int left, int right) {
    int tempPivot = left;
    int tempPivotVal = nums[tempPivot];

    int i = left + 1;
    int j = right;

    while(true) {
      while (i < right && nums[i] <= tempPivotVal) {
        i++;
      }
      while (j > left && nums[j] >= tempPivotVal) {
        j--;
      }
      if (i >= j) {
        break;
      }
      swap(nums, i, j);
    }
    swap(nums, tempPivot, j);
    return j;
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
