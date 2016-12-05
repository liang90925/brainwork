// test case: "210" should return []

import java.util.*;

public class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.equals("")) {
      return result;
    }
    // NOTE: Map<Character, char[]>, 两个char不一样
    // remember to use put
    // remember to use new char[] {}
    Map<Character, char[]> digitToLetterMap = new HashMap<>();
    digitToLetterMap.put('0', new char[] {});
    digitToLetterMap.put('1', new char[] {});
    digitToLetterMap.put('2', new char[] {'a', 'b', 'c'});
    digitToLetterMap.put('3', new char[] {'d', 'e', 'f'});
    digitToLetterMap.put('4', new char[] {'g', 'h', 'i'});
    digitToLetterMap.put('5', new char[] {'j', 'k', 'l'});
    digitToLetterMap.put('6', new char[] {'m', 'n', 'o'});
    digitToLetterMap.put('7', new char[] {'p', 'q', 'r', 's'});
    digitToLetterMap.put('8', new char[] {'t', 'u', 'v'});
    digitToLetterMap.put('9', new char[] {'w', 'x', 'y', 'z'});

    StringBuilder sb = new StringBuilder();
    helper(digits, sb, result, digitToLetterMap);
    return result;
  }

  private void helper(String digits, StringBuilder sb, List<String> result,
  Map<Character, char[]> digitToLetterMap) {
    if (sb.length() == digits.length()) {
      result.add(sb.toString());
      return;
    }
    for (char c : digitToLetterMap.get(digits.charAt(sb.length()))) {
      sb.append(c);
      helper(digits, sb, result, digitToLetterMap);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
