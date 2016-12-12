public class Solution {
  public List<String> generatePalindromes(String s) {
    List<String> result = new ArrayList<>();
    if (s == null) {
      return result;
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
    StringBuilder sb = new StringBuilder();
    char singleChar = '#';

    for (Character ch : charToCountMap.keySet()) {
      int chCount = charToCountMap.get(ch);
      if (chCount % 2 == 1) {
        if (oneCharExisted) {
          return result;
        } else {
          oneCharExisted = true;
          singleChar = ch;
        }
      }
      for (int i = 0; i < chCount / 2; i++) {
        sb.append(ch);
      }
    }

    String halfStr = sb.toString();
    boolean[] visited = new boolean[halfStr.length()];
    StringBuilder newSb = new StringBuilder();
    permutation(singleChar, newSb, halfStr, result, visited);
    return result;
  }

  private void permutation(char singleChar, StringBuilder sb, String halfStr, List<String> result, boolean[] visited) {
    if (sb.length() == halfStr.length()) {
      String temp = "";
      if (singleChar != '#') {
        temp = sb.toString() + singleChar + sb.reverse().toString();
      } else {
        temp = sb.toString() + sb.reverse().toString();
      }
      sb.reverse();
      result.add(temp);
      return;
    }
    for (int i = 0; i < halfStr.length(); i++) {
      if (visited[i] || (i != 0 && halfStr.charAt(i) == halfStr.charAt(i - 1) && !visited[i - 1])) {
        continue;
      }
      sb.append(halfStr.charAt(i));
      visited[i] = true;
      permutation(singleChar, sb, halfStr, result, visited);
      sb.deleteCharAt(sb.length() - 1);
      visited[i] = false;
    }
  }
}
