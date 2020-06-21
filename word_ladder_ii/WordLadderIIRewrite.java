import java.util.*;

public class WordLadderIIRewrite {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        // Ignored checking input
        dict.add(start);
        dict.add(end);

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> wordMap = new HashMap<>();
        Map<String, Integer> wordDistance = new HashMap<>();

        bfs(start, end, dict, wordMap, wordDistance);
        dfs(start, end, 0, wordMap, wordDistance, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String start,
                     String end,
                     int step,
                     Map<String, List<String>> wordMap,
                     Map<String, Integer> wordDistance,
                     List<String> path,
                     List<List<String>> result) {
        path.add(start);
        if (start.equals(end)) {
            result.add(new ArrayList<>(path));
        } else {
            for (String nextWord: wordMap.get(start)) {
                if (wordDistance.get(nextWord) == step + 1) {
                    dfs(nextWord, end, step + 1, wordMap, wordDistance, path, result);
                }
            }
        }
        path.remove(path.size()- 1);
    }


    private void bfs(String start,
                    String end,
                    Set<String> dict,
                    Map<String, List<String>> wordMap,
                    Map<String, Integer> wordDistance) {
        for (String word: dict) {
            wordMap.put(word, new ArrayList<>());
        }
        Queue<String> que = new LinkedList<>();
        que.add(start);
        int step = 0;
        wordDistance.put(start, step);

        while(!que.isEmpty()) {
            step++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                String curr = que.poll();
                if (curr.equals(end)) {
                    return;
                }

                // get candidates to the queue
                for (String nextWord: getNextWord(curr, dict)) {
                    wordMap.getOrDefault(curr, new ArrayList<>()).add(nextWord);
                    if (!wordDistance.containsKey(nextWord)) {
                        que.offer(nextWord);
                        wordDistance.put(nextWord, step);
                    }
                }
            }
        }
    }
    private List<String> getNextWord(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                String changed = replaceCharAt(i, c, word);
                if (dict.contains(changed)) {
                    nextWords.add(changed);
                }
            }
        }
        return nextWords;
    }

    private String replaceCharAt(int i, char c, String string) {
        char[] ch = string.toCharArray();
        ch[i] = c;
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        WordLadderIIRewrite solution = new WordLadderIIRewrite();
        System.out.println(solution.findLadders("a", "c", new HashSet<>(Arrays.asList("a", "b", "c"))));
        System.out.println(solution.findLadders("hit", "cog", new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"))));
        System.out.println(solution.findLadders("hot", "dog", new HashSet<>(Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"))));
    }
}


