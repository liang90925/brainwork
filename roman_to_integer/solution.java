public class Solution {
  public int romanToInt (String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> romanMap = new HashMap<>();
    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);

    int len = s.length();

    int result = romanMap.get(s.charAt(len - 1));

    for (int i = len - 2; i >= 0; i--) {
      if (romanMap.get(s.charAt(i + 1)) <= romanMap.get(s.charAt(i))) {
        result += romanMap.get(s.charAt(i));
      } else {
        result -= romanMap.get(s.charAt(i));
      }
    }
    return result;
  }
}
