public class SubstringWithAtleastKDistinctCharacters {

    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here

        int len = s.length();
        if (len < k) {
            return 0;
        }
        int[] letterCnt = new int[26];
        long totalCnt = 0;
        int kCnt = 0;
        int left = 0;
        int right = 0;

        while (left <= right && left < len) {
            while(kCnt < k && right < len) {
                letterCnt[charIdx(s, right)]++;
                if (letterCnt[charIdx(s, right)] == 1) {
                    kCnt++;
                }
                right++;
            }
            if (kCnt == k) {
                totalCnt += len - right + 1;
            }
            if (letterCnt[charIdx(s, left)] == 1) {
                kCnt -= 1;
            }
            letterCnt[charIdx(s, left)]--;
            left++;
        }
        return totalCnt;
    }

    private int charIdx(String s, int idx) {
        return s.charAt(idx) - 'a';
    }

    public static void main(String[] args) {
        SubstringWithAtleastKDistinctCharacters solution = new SubstringWithAtleastKDistinctCharacters();
        System.out.println(solution.kDistinctCharacters("abcabcabcabc", 3));
        System.out.println(solution.kDistinctCharacters("abcabcabca", 4));
        System.out.println(solution.kDistinctCharacters("abcccccba", 3));
        System.out.println(solution.kDistinctCharacters("abcccccbaabc", 3));
    }


}
