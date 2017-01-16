public class Solution {
  public boolean wordPattern(String pattern, String str) {
    Map<Character, String> wordMap = new HashMap<>();
    String[] strList = str.split(" ");
    if (pattern.length() != strList.length) {
      return false;
    }

    for (int i = 0; i < pattern.length(); i++) {
      if (wordMap.containsKey(pattern.charAt(i))) {
        if (!strList[i].equals(wordMap.get(pattern.charAt(i)))) {
          return false;
        }
      } else if (wordMap.containsValue(strList[i])){
          return false;
      } else {
        wordMap.put(pattern.charAt(i), strList[i]);
      }
    }

    return true;
  }
}
