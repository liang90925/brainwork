import java.util.*;
// still use the DFS to go through all  combinations, but can build boolean arrays to faciliate it
// so that we can skip many impossible combinations.

public class Solution {
  public List<String> wordBreak(String s, Set<String> wordDict) {
    // build an two D array to store whether s.substring(i,j) is a word in wordDict; (a top right half triangle two d array)
    // build another one D array to store whether start from i of the s, it is possible to find combinations of words in wordDict.

    if (s == null || s.length() == 0 || wordDict == null) {
      return Collections.emptyList();
    }
    int sSize = s.length();

    // build the two D array
    boolean[][] isWord = new boolean[sSize][sSize];
    for (int i = 0; i < sSize; i++) {
      for (int j = i; j < sSize; j++) {
        String word = s.substring(i, j + 1);
        isWord[i][j] = wordDict.contains(word);
      }
    }

    // build the one d array
    boolean[] possible = new boolean[sSize + 1];
    possible[sSize] = true;
    for (int i = sSize - 1; i >= 0; i--) {
      for (int j = sSize - 1; j >= i; j--) {
        if (isWord[i][j] && possible[j + 1]) {
          possible[i] = true;
          break;
        }
      }
    }

    List<Integer> path = new ArrayList<>();
    List<String> result = new ArrayList<>();
    search(0, s, path, isWord, possible, result);
    return result;
  }

  private void search(int index, String s, List<Integer> path, boolean[][] isWord, boolean[] possible, List<String> result) {
    if (!possible[index]) {
      return;
    }
    // build one possible combination string and put to result.
    if (index == s.length()) {
      int lastIndex = 0;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < path.size(); i++) {
        String word = s.substring(lastIndex, path.get(i));
        sb.append(word);
        if (i != path.size() - 1) {
          sb.append(" ");
        }
        lastIndex = path.get(i);
      }
      result.add(sb.toString());
      return;
    }

    // dfs part with pruning（剪枝）
    for (int i = index; i < s.length(); i++) {
      if (isWord[index][i]) {
        path.add(i + 1);
        search(i + 1, s, path, isWord, possible, result);
        path.remove(path.size() - 1);
      }
    }
  }
}
