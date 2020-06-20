import java.util.*;

public class IntersectionOfTwoArraysIIV2 {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0, index = 0;
    int[] tempResult = new int[nums1.length];
    while( i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        tempResult[index] = nums1[i];
        i++;
        j++;
        index++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      }
    }

    int[] result = new int[index];
    if (index >= 0) System.arraycopy(tempResult, 0, result, 0, index);
    return result;
  }
}
