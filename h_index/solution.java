public class Solution {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int hIndex = 0;
    if (citations == null || citations.length == 0) {
      return hIndex;
    }

    for (int i = 0; i < citations.length; i++) {
      int curr = Math.min(citations[i], citations.length - i);
      hIndex = Math.max(curr, hIndex);
    }
    return hIndex;
  }
}
