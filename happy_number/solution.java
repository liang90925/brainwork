public class Solution {
  public boolean isHappy(int n) {
    List<Integer> nums = new ArrayList<>();

    while (n != 1) {
      if (nums.contains(n)) {
        return false;
      }
      nums.add(n);
      n = multiplication(n);
    }
    return true;
  }
  private int multiplication(int n) {
    int result = 0;
    while (n > 0) {
      int single = n%10;
      result += single * single;
      n /= 10;
    }
    return result;
  }
}
