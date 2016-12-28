public class Solution {

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    if (words == null || words.length <= 2) {
      return Collections.emptyList();
    }

    List<String> result = new ArrayList<>();
    Set<String> wordSet = new HashSet<>();
    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    int max = 0;

    for (String word : words) {
      int wordLen = word.length();
      if (wordLen < min) {
        secondMin = min;
        min = wordLen;
      } else if (wordLen < secondMin) {
        secondMin = wordLen;
      }
      max = Math.max(max, wordLen);
      wordSet.add(word);
    }

    int minLen = min + min;

    for (String word : words) {
      int wordLen = word.length();
      if (wordLen < minLen) {
        continue;
      }
      if (search(word, 0, min, max, wordSet, 0)) {
        result.add(word);
      }
    }

    return result;
  }

  private boolean search(String word, int start, int min, int max, Set<String> wordSet, int count) {
    // when reach the end;
    if (start == word.length()) {
      return count > 1;
    }

    for (int i = min; i < max; i++) {
      if (start + i > word.length()) {
        break;
      }
      String subStr = word.substring(start, start + i);
      if (wordSet.contains(subStr)) {
        if (search(word, start + i, min, max, wordSet, count + 1)) {
          return true;
        }
      }
    }
    return false;
  }
}
