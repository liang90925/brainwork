public class Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    int indx1 = -1, indx2 = -1, dist = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      if (word1.equals(word2)) {
        if (words[i] == word1) {
          if (indx1 > indx2) {
            indx2 = i;
          } else {
            indx1 = i;
          }
        }
      } else {
        if (word[i].equals(word1)) {
          indx1 = i;
        }
        if (word[i].equals(word2)) {
          indx2 = i;
        }
      }
      if (indx1 > -1 && indx2 > -1) {
        dist = Math.min(dist, Math.abs(indx1 - indx2));
      }
    }
    return dist;
  }
}
