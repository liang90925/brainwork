public class Solution {
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }
    int[] sizeMap = new int[26];
    char[] sChar = s.toCharArray();
    char[] tChar = t.toCharArray();
    for (char sC : sChar) {
      sizeMap[sC-'a']++;
    }
    for (char tC : tChar) {
      if (--sizeMap[tC-'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
