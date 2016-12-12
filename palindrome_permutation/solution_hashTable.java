public class Solution {
  public boolean canPermutePalindrome(String s) {
    if (s == null) {
      return false;
    }
    Map<Character, Integer> charToCountMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (charToCountMap.containsKey(c)) {
        charToCountMap.put(c, charToCountMap.get(c) + 1);
      } else {
        charToCountMap.put(c, 1);
      }
    }
    boolean oneCharExisted = false;
    for (int count : charToCountMap.values()) {
      if (count % 2 == 1) {
        if (oneCharExisted) {
          return false;
        } else {
          oneCharExisted = true;
        }
      }
    }
    return true;
  }
}
