public class WordDistance {
  private Map<String, List<Integer>> wordIndxMap = new HashMap<>();

  public WordDistance(String[] words) {
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
  }

  public int shortest(String word1, String word2) {
    List<Integer> word1Inx = wordIndxMap.get(word1);
    List<Integer> word2Inx = wordIndxMap.get(word2);
    int i = 0, j = 0, dist = Integer.MAX_VALUE;
    while (i < word1Inx.size() && j < word2Inx.size()) {
      dist = Math.min(dist, Math.abs(word1Inx.get(i) - word2Inx.get(j)));

      if (word1Inx.get(i) < word2Inx.get(j)) {
        i++;
      } else {
        j++;
      }
    }
    // while (i < word1Inx.size() && j < word2Inx.size()) {
    //   dist = Math.min(dist, Math.abs(word1Inx.get(i) - word2Inx.get(j)));
    //
    //   if (word1Inx.get(i) < word2Inx.get(j)) {
    //     i++;
    //   } else {
    //     j++;
    //   }
    // }
    return dist;
  }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
