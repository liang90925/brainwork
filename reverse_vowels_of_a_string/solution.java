public class Solution {
  public String reverseVowels(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    String vowels = "aeiouAEIOU";
    char[] ch = s.toCharArray();
    int i = 0, j = ch.length - 1;
    while (i < j) {
      if (vowels.contains(Character.toString(ch[i])) && vowels.contains(Character.toString(ch[j]))) {
        char temp = ch[j];
        ch[j] = ch[i];
        ch[i] = temp;
        i++; j--;
      }
      if (!vowels.contains(Character.toString(ch[i]))) {
        i++;
      }
      if (!vowels.contains(Character.toString(ch[j]))) {
        j--;
      }
    }
    return new String(ch);
  }
}
