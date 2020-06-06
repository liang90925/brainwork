public class FastPower {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0) {
            return 1;
        }
        if (a == 1) {
            return 1;
        }
        int val = fastPower(a, b, n/2) % b;
        if (n % 2 == 0) {
            return val * val % b;
        } else {
            return val * val * a % b;
        }

    }

    public static void main(String[] args) {

    }
}
