public class RatJumpMissLeading {
    private static int[] STEPS_AT_EVEN = new int[] {1, 3, 4};
    private static int[] STEPS_AT_ODD = new int[] {1, 2, 4};

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
        int[] evenJump = new int[extendedLen];
        int[] oddJump = new int[extendedLen];
        int[] extendedArr = new int[extendedLen];

        for (int i = 0; i < extendedLen; i ++) {
            if (i >= len) {
                extendedArr[i] = 0;
            } else {
                extendedArr[i] = arr[i];
            }
        }

        evenJump[0] = 1;
        oddJump[0] = 0;

        for (int i = 1; i < extendedLen; i++) {
            if (extendedArr[i] == 1) {
                evenJump[i] = 0;
                oddJump[i] = 0;
            } else {
                // Check even
                int evenSum = 0;
                for (int step : STEPS_AT_EVEN) {
                    if (i - step >= 0 && i - step < len - 1 ) {
                        evenSum += oddJump[i - step];
                    }

                }
                evenJump[i] = evenSum;

                // Check odd
                int oddSum = 0;
                for (int step : STEPS_AT_ODD) {
                    if (i - step >= 0 && i - step < len - 1 ) {
                            oddSum += evenJump[i - step];
                    }
                }
                oddJump[i] = oddSum;
            }
        }

        int totalPath = 0;
        for (int i = len - 1; i < extendedLen; i++) {
            totalPath += evenJump[i];
            totalPath += oddJump[i];
        }
        return totalPath;
    }

    public static void main(String[] args) {
        RatJumpMissLeading ratJump = new RatJumpMissLeading();
        System.out.println(ratJump.ratJump(new int[]{0, 0, 0}) + " === 5");
        System.out.println(ratJump.ratJump(new int[]{0, 0, 1, 0}) + " === 3");
    }
}