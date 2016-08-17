public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || s.length()==0 || words.length == 0) {
            return result;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        Map<String, Integer> sTempMap = new HashMap<>();

        int wordsLen = words.length;
        int wordSize = words[0].length();

        // transfer words in to a words Map with each words as key and the number of occurance as the value
        for (int i = 0; i < wordsLen; i++) {
            if (wordsMap.containsKey(words[i])) {
                wordsMap.put(words[i], wordsMap.get(words[i]) + 1);
            } else {
                wordsMap.put(words[i], 1);
            }
        }

        for (int j = 0; j <= s.length() - wordsLen * wordSize; j++) {
            sTempMap.clear();
            int i;
            for (i = 0; i < wordsLen; i++) {
                int innerIndex = j + i * wordSize;
                String tempWord = s.substring(innerIndex, innerIndex + wordSize);
                if (!wordsMap.containsKey(tempWord)) {
                    break;
                }
                if (sTempMap.containsKey(tempWord)) {
                    sTempMap.put(tempWord, sTempMap.get(tempWord) + 1);
                } else {
                    sTempMap.put(tempWord, 1);
                }
                if (sTempMap.get(tempWord) > wordsMap.get(tempWord)) {
                    break;
                }
            }
            if (i == wordsLen) {
                result.add(j);
            }
        }
        return result;
    }
}
