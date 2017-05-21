public class Solution {
  public int longestPalindrome(String s) {
    if (s == null) {
      return 0;
    }
    if (s.length() <= 1) {
      return s.length();
    }

    HashMap<Character, Integer> strToNum = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (strToNum.containsKey(ch)) {
        strToNum.put(ch, strToNum.get(ch) + 1);
      } else {
        strToNum.put(ch, 1);
      }
    }
    int result = 0;
    boolean hasOddNum = false;
    for (Integer num : strToNum.values()) {
      if (num % 2 == 0) {
        result += num;
      } else {
        hasOddNum = true;
        result += (num - 1);
      }
    }
    if (hasOddNum) {
      result++;
    }
    return result;
  }
}
