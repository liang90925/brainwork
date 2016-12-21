
public class Solution {
  public String getPermutation(int n, int k) {
    if ( n <= 0 || k < 0) {
      return "";
    }
    // NOTE!! Important step
    k--; // to transfer it as begin from 0 rather than 1

    List<Integer> numList = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      numList.add(i);
    }

    int factorial = 1;
    for (int i = 1; i < n; i++) {
      factorial *= i;
    }

    StringBuilder sb = new StringBuilder();
    int times = n - 1;

    while (times >= 0) {
      int indexInList = k / factorial;
      sb.append(numList.get(indexInList));
      numList.remove(indexInList);

      k = k % factorial;
      if (times != 0) {
        factorial /= times;
      }
      times--;
    }

    return sb.toString();
  }
}
