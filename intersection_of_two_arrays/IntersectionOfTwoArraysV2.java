//sort and merge

import java.util.Arrays;

public class IntersectionOfTwoArraysV2 {
    public int[] intersection(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int[] temp = new int[nums1.length];
      int i = 0, j = 0, index = 0;
      while (i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j]) {
          if (index == 0 || temp[index - 1] != nums1[i]) {
            temp[index++] = nums1[i];
          }
          i++; j++;
        } else if (nums1[i] < nums2[j]) {
          i++;
        } else if (nums1[i] > nums2[j]) {
          j++;
        }
      }
      int[] result = new int[index];
      for (i = 0; i < index; i++) {
        result[i] = temp[i];
      }
      return result;
    }
}
