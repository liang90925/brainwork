// this is a better Solution
// referred to http://massivealgorithms.blogspot.com/2016/10/leetcode-409-longest-palindrome.html

public class Solution {
  public int longestPalindrome(String s) {
    if(s==null || s.length()==0) {
      return 0;
    }
    HashSet<Character> chSet = new HashSet<>();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (chSet.contains(ch)) {
        chSet.remove(ch);
        count += 2;
      } else {
        chSet.add(ch);
      }
    }
    return chSet.isEmpty() ? count : count + 1;
  }
}
