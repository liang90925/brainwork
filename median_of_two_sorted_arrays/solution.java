public class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total_length = nums1.length + nums2.length;
    if (total_length % 2 == 1) {
      return getKthNumber(nums1, 0, nums2, 0, total_length/2 + 1);
    } else {
      return (getKthNumber(nums1, 0, nums2, 0, total_length/2) +
        getKthNumber(nums1, 0, nums2, 0, total_length/2 + 1)) / 2.0;
    }
  }
  private static double getKthNumber(int[] nums1, int n1_start, int[] nums2,
    int n2_start, int k) {

    // similar to the new nums1 array is an empty array;
    // So the kth number will be nums2's kth number, which is nums2[k - 1]
    if (n1_start >= nums1.length) {
      return nums2[n2_start + k - 1];
    }

    // similar to the new nums2 array is an empty array;
    // So the kth number will be nums1's kth number, which is nums1[k - 1]
    if (n2_start >= nums2.length) {
      return nums1[n1_start + k - 1];
    }

    // k == 1, means to get the first number of two array,
    // so just need to return the minimum of each arrays's first element
    if (k == 1) {
      return Math.min(nums1[n1_start], nums2[n2_start]);
    }

    // in case the index of the comparing key doesn't exist,
    // we set the key value as the MAX_VALUE
    // therefore, in the return element, the start of the array will not change.
    int n1_key = n1_start + k/2 -1 < nums1.length ?
      nums1[n1_start + k/2 -1] : Integer.MAX_VALUE;
    int n2_key = n2_start + k/2 -1 < nums2.length ?
      nums2[n2_start + k/2 -1] : Integer.MAX_VALUE;

    if (n1_key < n2_key) {
      return (double) getKthNumber(nums1, n1_start + k/2, nums2, n2_start, k - k/2);
    } else {
      return (double) getKthNumber(nums1, n1_start, nums2, n2_start + k/2, k - k/2);
    }
  }
}
