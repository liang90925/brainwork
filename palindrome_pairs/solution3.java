// verison 3 with test cases

import java.io.*;
import java.util.*;

class Solution {
  public static List<List<Integer>> findPalindromes(String[] words){
    if (words == null || words.length < 2) {
      return Collections.emptyList();
    }

    int lth = words.length;

    // create a map to store the reversed words as key and index as value
    Map<String, Integer> reversedWordsMap = new HashMap<>();
    for (int i = 0; i < lth; i++) {
      reversedWordsMap.put(new StringBuilder().append(words[i]).reverse().toString(), i);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < lth; i++) {
      for (int j = 0; j <= words[i].length(); j++) {
        String prefix = words[i].substring(0, j);
        String postfix = words[i].substring(j);
        checkPalindromes(prefix, postfix, result, reversedWordsMap, i, false);
        if (postfix.length() != 0) {
          checkPalindromes(postfix, prefix, result, reversedWordsMap, i, true);
        }
      }
    }
    return result;
  }

  public static void checkPalindromes(String word1, String word2, List<List<Integer>> result,
    Map<String, Integer> wordsMap, int index, boolean reverse) {

    if (isPalindrome(word1) && wordsMap.containsKey(word2) && wordsMap.get(word2) != index) {
      List<Integer> temp = new ArrayList<>();
      if (reverse) {
        temp.add(index);
        temp.add(wordsMap.get(word2));
      } else {
        temp.add(wordsMap.get(word2));
        temp.add(index);
      }
      result.add(temp);
    }
  }

  public static boolean isPalindrome(String word) {
    for (int i = 0; i < word.toCharArray().length / 2; i++) {
      if (word.charAt(i) != word.charAt(word.toCharArray().length - i - 1)) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
    String[] words = {"aab", "abcd", "dcba", "b", "a", "aa"};
    System.out.println(findPalindromes(words));

  }
}
