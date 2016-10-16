// use two pinters and only need O(n) complexity

public class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    if (words == null || word1 == null || word2 == null) {
      return -1;
    }
    int indx1 = -1;
    int indx2 = -1;
    int dist = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        indx1 = i;
      }
      if (words[i].equals(word2)) {
        indx2 = i;
      }
      if (indx1 != -1 && indx2 != -1) {
        dist = Math.min(dist, Math.abs(indx1 - indx2));
      }
    }
    return dist;
  }
}
