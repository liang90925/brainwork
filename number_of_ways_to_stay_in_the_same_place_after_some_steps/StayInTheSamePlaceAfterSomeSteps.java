public class StayInTheSamePlaceAfterSomeSteps {
    // Time limit exceeded with case 27, 7
    public int numWays(int steps, int arrLen) {
        if (arrLen == 0 || steps == 0) {
            return 0;
        }
        return dfs(0, 0, 0, steps, arrLen);

    }

    public int dfs(int currStep, int currIdx, int numOfWays, int steps, int arrLen) {
        if (currIdx < 0 || currIdx >= arrLen) {
            return 0;
        }
        if (currStep > steps) {
            return 0;
        }
        if ((numOfWays - currStep) > currIdx) {
            return 0;
        }
        if (currStep == steps && currIdx != 0) {
            return 0;
        }
        if (currStep == steps && currIdx == 0) {
            return 1;
        }

        return numOfWays
                // stay
                + dfs(currStep + 1, currIdx, numOfWays, steps, arrLen)
                // left
                + dfs(currStep + 1, currIdx - 1, numOfWays, steps, arrLen)
                //right
                + dfs(currStep + 1, currIdx + 1, numOfWays, steps, arrLen);

    }

    public static void main(String[] args) {
        StayInTheSamePlaceAfterSomeSteps solution = new StayInTheSamePlaceAfterSomeSteps();

        System.out.println(solution.numWays(3, 2));
        System.out.println(solution.numWays(2, 4));
        System.out.println(solution.numWays(4, 2));
        System.out.println(solution.numWays(27, 7));
    }
}
