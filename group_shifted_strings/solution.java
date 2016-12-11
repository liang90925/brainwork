public class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> result = new ArrayList<>();
    if (strings == null || strings.length == 0) {
      return result;
    }

    Map<String, List<String>> keyToStrMap = new HashMap<>();
    for (String str : strings) {
      String key = "";
      for (int i = 1; i < str.length(); i++) {
        // this part is very important!!! especially the part to check offset >0 or not
        int offset = str.charAt(i) - str.charAt(i - 1);
        key += offset > 0 ? offset : offset + 26;
      }
      if (keyToStrMap.containsKey(key)) {
        keyToStrMap.get(key).add(str);
      } else {
        List<String> strs = new ArrayList<>();
        strs.add(str);
        keyToStrMap.put(key, strs);
      }
    }

    for (List<String> strs : keyToStrMap.values()) {
      result.add(strs);
    }

    return result;
  }
}
