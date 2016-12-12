public class Solution {
  public boolean canPermutePalindrome(String s) {
    if (s == null) {
      return false;
    }
    Set<Character> charSet = new HashSet<>();
    for (Character ch : s.toCharArray()) {
      if (charSet.contains(ch)) {
        // 偶数次移除
        charSet.remove(ch);
      } else {
        // 奇数次加入
        charSet.add(ch);
      }
    }
    return charSet.size() <= 1;
  }
}
