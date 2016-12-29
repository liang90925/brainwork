public class Solution {
  public int numWays(int n, int k) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    int same = k;
    int diff = k * (k - 1);

    for (int i = 3; i <= n; i++) {
      int temp = (k - 1) * (same + diff);
      same = diff;
      diff = temp;
    }
    return same + diff;
  }
}
