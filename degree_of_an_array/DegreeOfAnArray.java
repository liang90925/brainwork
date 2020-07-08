import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int x= nums[i];
            if (!leftMap.containsKey(x)) {
                leftMap.put(x, i);
            }
            rightMap.put(x, i);
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        int ans = len;
        int maxCnt = Collections.max(countMap.values());
        for (int key: countMap.keySet()) {
            if (countMap.get(key) == maxCnt) {
                ans = Math.min(ans, rightMap.get(key) - leftMap.get(key) + 1);
            }
        }
        return ans;
    }

}

//    Time Complexity: O(N)O(N), where NN is the length of nums. Every loop is through O(N)O(N) items with O(1)O(1) work inside the for-block.
//
//        Space Complexity: O(N)O(N), the space used by left, right, and count.
