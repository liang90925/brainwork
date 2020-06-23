public class ClimbingStairsMemorySearch {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1) {
            return n;
        }

        int[] result = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            result[i] = -1;
        }
        search(n, result);
        return result[n];
    }
    public void search(int index, int[] result) {
       if (result[index] != -1) {
           return;
       }
       if (index == 0 || index == 1) {
           result[index] = 1;
           return;
       }
       search(index - 1, result);
       search(index - 2, result);
       result[index] = result[index - 1] + result[index - 2];
    }

    public static void main(String[] args) {
        ClimbingStairsMemorySearch climbingStairs = new ClimbingStairsMemorySearch();
        System.out.println(climbingStairs.climbStairs(3) + " === 3");
        System.out.println(climbingStairs.climbStairs(5) + " === 8");
    }
}
