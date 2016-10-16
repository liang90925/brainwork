public class Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    Map<String, List<Integer>> wordIndxMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      List<Integer> indx;
      if (!wordIndxMap.containsKey(words[i])) {
        indx = new ArrayList<>();
        wordIndxMap.put(words[i], indx);
      } else {
        indx = wordIndxMap.get(words[i]);
      }
      indx.add(i);
    }

    int i = 0, j = 0, dist = Integer.MAX_VALUE;
    List<Integer> w1Indx = wordIndxMap.get(word1);
    List<Integer> w2Indx = wordIndxMap.get(word2);
    while (i < w1Indx.size() && j < w2Indx.size()) {
      if (w1Indx.get(i) != w2Indx.get(j)) {
        dist = Math.min(dist, Math.abs(w1Indx.get(i) - w2Indx.get(j)));
      }
      if (w1Indx.get(i) < w2Indx.get(j)) {
          i++;
      } else {
          j++;
      }
    }
    return dist;
  }
}
