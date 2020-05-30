import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> resultMap = new HashMap<>();
    for (int i = 0; i< nums.length; i++) {
      if (resultMap.get(nums[i]) != null) {
        int[] result = {resultMap.get(nums[i]), i};
        return result;
      }
      resultMap.put(target - nums[i], i);
    }
    return null;
  }
}
