import java.util.HashMap;
import java.util.Map;

public class StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        if (stickers == null || stickers.length == 0) {
            return 0;
        }
        int len= stickers.length;
        int[][] letters = new int[len][26];

        for (int i =0; i<len; i++) {
            for (char ch: stickers[i].toCharArray()) {
                letters[i][ch - 'a']++;
            }
        }

        Map<String, Integer> targetToAnsMap = new HashMap<>();
        targetToAnsMap.put("", 0);
        return dfs(targetToAnsMap, letters, target);

    }

    private int dfs(Map<String, Integer> targetToAnsMap, int[][] letters, String target){
        if (targetToAnsMap.containsKey(target)) {
            return targetToAnsMap.get(target);
        }

        int ans = Integer.MAX_VALUE;

        int[] targetCnt = new int[26];
        for (char ch: target.toCharArray()) {
            targetCnt[ch - 'a']++;
        }

        for (int[] word : letters) {
            if (word[target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            // Form a new target that could not use the current letters from the current word
            for (int j = 0; j < 26; j++) {
                if (targetCnt[j] > 0) {
                    for (int k = 0; k < Math.max(0, targetCnt[j] - word[j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            String restOfTarget = sb.toString();
            int restOfCnt = dfs(targetToAnsMap, letters, restOfTarget);
            if (restOfCnt != -1) {
                ans = Math.min(ans, restOfCnt + 1);
            }
        }

        targetToAnsMap.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return targetToAnsMap.get(target);
    }

    public static void main(String[] args) {
        StickersToSpellWord solution = new StickersToSpellWord();
       // System.out.println(solution.minStickers(new String[]{"abcdef", "hcj"}, "jcce") + " === 2");;
       // System.out.println(solution.minStickers(new String[]{"abcdef", "hcjce"}, "ccej") + " === 1");
//        System.out.println(solution.minStickers(new String[]{"abcdef", "hj"}, "ccej") + " === -1");
        System.out.println(solution.minStickers(new String[]{"bacf", "bac"}, "abc") + " === 1");
    }
}
