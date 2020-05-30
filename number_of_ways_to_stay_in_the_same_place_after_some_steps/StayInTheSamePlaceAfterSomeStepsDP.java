public class StayInTheSamePlaceAfterSomeStepsDP {
    private final static long MOD = 1000000007L;

    public int numWays(int steps, int arrLen) {
        // if (arrLen == 0 || steps == 0) {
        //     return 0;
        // }
        // if (arrLen == 1) {
        //     return 1;
        // }
        int numMemCol = Math.min(steps/2 + 1, arrLen);
        long[][] numMem = new long[steps][numMemCol];
        numMem[0][0] = 1;
        numMem[0][1] = 1;

        for (int i = 1; i < steps; i++) {
            for (int j = 0; j < numMemCol; j++) {
                if ((j - i) > 1) {
                    break;
                }
                // above + // leftabove + rightabove
                long above = numMem[i - 1][j];
                long leftAbove = j - 1 >= 0 ? numMem[i - 1][j - 1] : 0;
                long righAbove = j + 1 < numMemCol ? numMem[i - 1][ j + 1] : 0;
                numMem[i][j] = (above + leftAbove + righAbove) % MOD;
            }
        }
        long result = numMem[steps - 1][0];
        return modResult(result);
    }

    private int modResult(long bigNum) {
        return (int) (bigNum % MOD);
    }

    public static void main(String[] args) {
        StayInTheSamePlaceAfterSomeStepsDP solution = new StayInTheSamePlaceAfterSomeStepsDP();
        System.out.println(solution.numWays(3, 2));
        solution.numWays(3, 2);
        System.out.println(solution.numWays(2, 4));
        System.out.println(solution.numWays(4, 2));
        System.out.println(solution.numWays(4, 3));
        System.out.println(solution.numWays(27, 7));
    }
}
