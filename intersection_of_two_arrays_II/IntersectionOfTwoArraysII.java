import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
  public int[] intersection(int[] nums1, int[] nums2) {
    Map<Integer, Integer> nums1Map = new HashMap<>();

    for (int i = 0; i < nums1.length; i++) {
      if (nums1Map.containsKey(nums1[i])) {
        nums1Map.put(nums1[i], nums1Map.get(nums1[i]) + 1);
      } else {
        nums1Map.put(nums1[i], 1);
      }
    }

    List<Integer> nums2List = new ArrayList<>();
    for (int i = 0; i < nums2.length; i++) {
      if (nums1Map.containsKey(nums2[i]) && nums1Map.get(nums2[i]) > 0) {
        nums2List.add(nums2[i]);
        nums1Map.put(nums2[i], nums1Map.get(nums2[i]) - 1);
      }
    }

    int[] result = new int[nums2List.size()];
    for (int i = 0; i < nums2List.size(); i++) {
      result[i] = nums2List.get(i);
    }
    return result;
  }
}
