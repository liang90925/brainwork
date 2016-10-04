//using two set

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

      Set<Integer> nums1Set = new HashSet<>();
      Set<Integer> nums2Set = new HashSet<>();
      for (int i = 0; i < nums1.length; i++) {
        if (!nums1Set.contains(nums1[i])) {
          nums1Set.add(nums1[i]);
        }
      }

      for (int i = 0; i < nums2.length; i++) {
        if (nums1Set.contains(nums2[i]) && !nums2Set.contains(nums2[i])) {
          nums2Set.add(nums2[i]);
        }
      }

      int[] result = new int[nums2Set.size()];
      int i = 0;
      for (Integer num : nums2Set) {
        result[i++] = num;
      }
      return result;
    }
}
