public class Solution {
  public boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, i = 0;

    for (int num : nums) {
      if ( num > second ) {
        return true;
      } else if (num <= first) {
        first = num;
      } else {
        second = num;
      }
    }

    return false;
  }
}
