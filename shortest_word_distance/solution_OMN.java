public class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    List<int> word1Inx = new ArrayList<>();
    List<int> word2Inx = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        word1Inx.add(i);
      }
      if (words[i].equals(word2)) {
        word2Inx.add(i);
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < word1Inx.size(); i++) {
      for (int j = 0; j < word2Inx.size(); i++) {
        int diff = Math.abs(word1Inx.get(i) - word2Inx.get(j));
        min = Math.min(min, diff);
      }
    }
    return min;
  }
}
