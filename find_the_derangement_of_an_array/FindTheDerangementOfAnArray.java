public class FindTheDerangementOfAnArray {
    /**
     * @param n: an array consisting of n integers from 1 to n
     * @return: the number of derangement it can generate
     */
    public int findDerangement(int n) {
        // Write your code here
        long mod = 1000000007;

        long[] pre = new long[2];
        pre[0] = 0;
        pre[1] = 1;
        if (n <= 2) {
            return (int) pre[n - 1];
        }
        for (int i = 3; i <= n; i++) {
            long temp = (pre[0] + pre[1]) % mod;
            long val = (i-1) * temp % mod;
            pre[0] = pre[1] % mod;
            pre[1] = val % mod;
        }

        return (int) pre[1];
    }

    public static void main(String[] args) {
        FindTheDerangementOfAnArray solution = new FindTheDerangementOfAnArray();

        System.out.println(solution.findDerangement(2));
        System.out.println(solution.findDerangement(3));
        System.out.println(solution.findDerangement(4));
        System.out.println(solution.findDerangement(5));
        System.out.println(solution.findDerangement(6));
        System.out.println(solution.findDerangement(7));
        System.out.println(solution.findDerangement(8));
        System.out.println(solution.findDerangement(9));
        System.out.println(solution.findDerangement(10));
    }
}
