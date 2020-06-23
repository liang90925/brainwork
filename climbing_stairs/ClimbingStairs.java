public class ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }

        int[] prev = new int[2];
        prev[0] = 1;
        prev[1] = 1;

        for (int i = 2; i <= n; i++) {
            int temp = prev[1];
            prev[1] += prev[0];
            prev[0] = temp;
        }
        return prev[1];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));
    }
}
