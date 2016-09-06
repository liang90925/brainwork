public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    // verify input
    if (strs == null || strs.length ==  0) {
      return new ArrayList<List<String>>();
    }
    // sort strs
    Arrays.sort(strs);

    // create the map that contains one word as the key and list of anagrams as value.
    Map<String, List<String>> anagramMap = new HashMap<>();

    for (String s : strs) {
      // transfer s to a sorted string that can be used as key for check
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String keyStr = new String(c);

      if (!anagramMap.containsKey(keyStr)) {
        anagramMap.put(keyStr,new ArrayList<>());
      }
      anagramMap.get(keyStr).add(s);
    }
    return new ArrayList<List<String>>(anagramMap.values());
  }
}
