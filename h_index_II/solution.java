public class Solution {
  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }

    int n = citations.length;
    int start = 0, end = n - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (citations[mid] < n - mid) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return n - start;
  }
}
