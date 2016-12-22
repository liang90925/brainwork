public class ValidWordAbbr {
  Map<String, Set<String>> abbrToWordMap = new HashMap<>();

  public ValidWordAbbr(String[] dictionary) {
    for (String word : dictionary) {
      String wordAbbr = getWordAbbr(word);
      Set<String> set;
      if (abbrToWordMap.containsKey(wordAbbr)) {
        set = abbrToWordMap.get(wordAbbr);
      } else {
        set = new HashSet<>();
      }
      set.add(word);
      abbrToWordMap.put(wordAbbr, set);
    }
  }

  public boolean isUnique(String word) {
    String wordAbbr = getWordAbbr(word);
    if (!abbrToWordMap.containsKey(wordAbbr)) {
      return true;
    } else if (abbrToWordMap.get(wordAbbr).size() == 1 &&
               abbrToWordMap.get(wordAbbr).contains(word)) {
      return true;
    }
    return false;
  }

  private String getWordAbbr(String word) {
    int wordLen = word.length();
    if (wordLen > 2) {
      String wordAbbr = new StringBuilder()
        .append(word.charAt(0))
        .append(wordLen - 2)
        .append(word.charAt(wordLen - 1))
        .toString();
      return wordAbbr;
    }
    return word;
  }
}
