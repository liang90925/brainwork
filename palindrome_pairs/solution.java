public class Solution {
  public static List<List<Integer>> palindromePairs(String[] words) {
      // Initiate return result.
      List<List<Integer>> result = new ArrayList<>();

      // pre check for input words array.
      if (words == null || words.length < 2) {
          return result;
      }

      // create a map to store each word as key and the index as the value.
      Map<String, Integer> wordsMap = new HashMap();
      int lth = words.length;
      for (int i = 0; i < lth; i++) {
          wordsMap.put(words[i], i);
      }

      // loop over the words array.
      for (int i = 0; i < lth; i++) {
          int wordLth = words[i].length();
          // loop over a single word to find possible palindrome
          for (int j = 0; j <= wordLth; j++) {
                  String word1 = words[i].substring(0, j);
                  String word2 = words[i].substring(j);
                  wordsPalindromeCheck(word1, word2, wordsMap, result, i, false);
                  if (word2.length()!=0) {
                    wordsPalindromeCheck(word2, word1, wordsMap, result, i, true);
                  }

          }
      }
      return result;
  }
  private static void wordsPalindromeCheck(String leftWord, String rightWord,
                                           Map<String, Integer> wordsMap,
                                           List<List<Integer>> result,
                                           int index, boolean reverse) {
      if (isPalindrome(leftWord)) {
          String rightWordReverse = new StringBuilder(rightWord).reverse().toString();
          if (wordsMap.containsKey(rightWordReverse) && wordsMap.get(rightWordReverse) != index) {
              List<Integer> singleList = new ArrayList<>();
              if (reverse) {
                  singleList.add(index);
                  singleList.add(wordsMap.get(rightWordReverse));
              } else {
                  singleList.add(wordsMap.get(rightWordReverse));
                  singleList.add(index);
              }

              result.add(singleList);
          }
      }
  }

  private static boolean isPalindrome(String word) {
      if (word == null || word.length() == 0) {
          return true;
      }
      for (int i = 0; i < word.length() / 2; i++) {
          if (word.charAt(i) != word.charAt(word.length() - i -1)) {
              return false;
          }
      }
      return true;
  }
}
