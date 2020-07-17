public class PalindromeSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int total = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i <= 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j]) {
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        PalindromeSubstrings solution = new PalindromeSubstrings();
        System.out.println(solution.countSubstrings("aaa") + " === 6");
        System.out.println(solution.countSubstrings("abd") + " === 3");
        System.out.println(solution.countSubstrings("aba") + " === 4");
    }
}
