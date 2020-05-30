public class Pow {
    public double myPow(double x, int n) {
        long N = n;
        if (n == 0) {
            return 1;
        }
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        double result = 1;
        double currVal = x;
        for (long i = N; i > 0; i = i /2) {
            if ((i % 2) == 1) {
                result = result * currVal;
            }
            currVal = currVal * currVal;
        }
        return result;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2.00000, 10) + ", should equal to 1024.00000");
        System.out.println(pow.myPow(2.10000, 3) + ", should equal to 9.26100");
        System.out.println(pow.myPow(2.00000, -2) + ", should equal to 0.25000");
    }
}
