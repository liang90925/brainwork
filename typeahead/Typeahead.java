import java.util.*;

public class Typeahead {

    Map<String, List<String>> typeAheadMap = new HashMap<>();

    /*
     * @param dict: A dictionary of words dict
     */
    public Typeahead(Set<String> dict) {
        // do intialization if necessary
        for (String content: dict) {
            int len = content.length();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    String sub = content.substring(i, j);
                    if (sub.length() > 0) {
                        List<String> storedContents = typeAheadMap.getOrDefault(sub, new ArrayList<>());
                        if (storedContents.size() == 0 || !storedContents.get(storedContents.size() - 1).equals(content)) {
                            storedContents.add(content);
                            typeAheadMap.put(sub, storedContents);
                        }
                    }
                }
            }
        }
    }

    /*
     * @param str: a string
     * @return: a list of words
     */
    public List<String> search(String str) {
        // write your code here
        if (typeAheadMap.containsKey(str)) {
            return typeAheadMap.get(str);
        }
        return new ArrayList<>();
    }
}
