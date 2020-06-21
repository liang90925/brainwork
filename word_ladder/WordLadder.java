import java.util.*;

public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // Ignored checking input
        dict.add(start);
        dict.add(end);

        Queue<String> que = new LinkedList<>();
        Set<String> used = new HashSet<>();
        que.add(start);
        used.add(start);

        int step = 0;
        while(!que.isEmpty()) {
            step++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                String curr = que.poll();
                if (curr.equals(end)) {
                    return step;
                }
                // get candidates to the queue
                for (String nextWord: getNextWord(curr, dict, used)) {
                    que.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private List<String> getNextWord(String word, Set<String> dict,  Set<String> used) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                String changed = replaceCharAt(i, c, word);
                if (dict.contains(changed) && !used.contains(changed)) {
                    used.add(changed);
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
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength("a", "c", new HashSet<>(Arrays.asList("a","b","c"))) + " === 2");
        System.out.println(wordLadder.ladderLength("hit", "cog", new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"))) + " === 5");
    }
}
