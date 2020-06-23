public class RatJumpMissLeadingImprove {
    private static int[][] STEPS = new int[][] {{1, 3, 4}, {1, 2, 4}};
    private static long MOD = 1000000007;
    /**
     * @param arr: the steps whether have glue
     * @return: the sum of the answers
     */
    public int ratJump(int[] arr) {
        // Write your code here.
        int len = arr.length;
        if (len <= 1) {
            return 0;
        }
        int extendedLen = len + 3;
        int[][] jumps = new int[2][extendedLen]; // 0 is for even Jumps 1 is for odd Jumps
        jumps[0][0] = 1; // first element of even jump is 1
        jumps[1][0] = 0; // first element of odd jump is 0

        int[] extendedArr = new int[extendedLen];

        for (int i = 0; i < extendedLen; i ++) {
            if (i >= len) {
                extendedArr[i] = 0;
            } else {
                extendedArr[i] = arr[i];
            }
        }

        for (int i = 1; i < extendedLen; i++) {
            if (extendedArr[i] == 1) {
                jumps[0][i] = 0;
                jumps[1][i] = 0;
            } else {
                int[] sums = new int[STEPS.length];
                for (int k = 0; k < STEPS.length; k++) {
                    for (int step : STEPS[k]) {
                        if (i - step >= 0 && i - step < len - 1 ) {
                            sums[k] += jumps[(k + 1)%2][i - step];
                            sums[k] %= MOD;
                        }
                    }
                    jumps[k][i] = sums[k];
                }
            }
        }

        int totalPath = 0;
        for (int[] jump : jumps) {
            for (int j = len - 1; j < extendedLen; j++) {
                totalPath += jump[j];
                totalPath %= MOD;
            }
        }

        return totalPath;
    }

    public static void main(String[] args) {
        RatJumpMissLeadingImprove ratJump = new RatJumpMissLeadingImprove();
        System.out.println(ratJump.ratJump(new int[]{0, 0, 0}) + " === 5");
        System.out.println(ratJump.ratJump(new int[]{0, 0, 1, 0}) + " === 3");
        System.out.println(ratJump.ratJump(new int[]{0, 1, 0, 0}) + " === 4");

    }
}