public class SqrtDouble {
    // Newton's method
    public double getSqrtDoubleSimple(double x) {
        if (x == 0) return 0;
        double a = Math.abs(x);
        double last = 0.0;
        double res = 1.0;
        while (res != last) {
            last = res;
            res = (res + a / res) / 2;
        }
        return x < 0 ? -1 * res : res;
    }
    public double getSqrtDouble(double a) {
        if (a == 0) return 0;
        double absA = Math.abs(a);
        absA = absA < 1.0 ? 1 / absA : absA;

        double x0 = absA;
        double x1 = (x0 + absA/x0) / 2.0;

        while (Math.abs(x0 - x1) >= 0.01) {
            x0 = x1;
            x1 = (x0 + absA/x0) / 2.0;
        }
        double result = x1;
        if (a < 0) {
            result *= -1;
        }
        if (Math.abs(a) < 1.0) {
            result = 1 / result;
        }
        return result;
    }

    // Binary Search method
    public double getSqrtDoubleBinarySearch(double a) {
        if (a == 0) return 0;
        double input = Math.abs(a);
        input = input < 1.0 ? 1 / input : input;

        double left = 1.0;
        double right = input;

        while (Math.abs(right - left) >= 0.0000001) {
            double mid = left + (right - left) / 2.0;
            double num = mid * mid;
            if (num > input) {
                right = mid;
            } else if (num < input) {
                left = mid;
            } else {
                return mid;
            }
        }

        double result = right;
        if (a < 0) {
            result *= -1;
        }
        if (Math.abs(a) < 1.0) {
            result = 1 / result;
        }
        return result;
    }
    public static void main(String[] args) {
        SqrtDouble sqrtDouble = new SqrtDouble();
        System.out.println(sqrtDouble.getSqrtDoubleSimple(0));
        System.out.println(sqrtDouble.getSqrtDoubleSimple(2.5));
        System.out.println(sqrtDouble.getSqrtDoubleSimple(-2.5));
        System.out.println(sqrtDouble.getSqrtDoubleSimple(0.1));
        System.out.println("========================");
        System.out.println(sqrtDouble.getSqrtDouble(0));
        System.out.println(sqrtDouble.getSqrtDouble(2.5));
        System.out.println(sqrtDouble.getSqrtDouble(-2.5));
        System.out.println(sqrtDouble.getSqrtDouble(0.1));
        System.out.println("========================");
        System.out.println(sqrtDouble.getSqrtDoubleBinarySearch(0));
        System.out.println(sqrtDouble.getSqrtDoubleBinarySearch(2.5));
        System.out.println(sqrtDouble.getSqrtDoubleBinarySearch(-2.5));
        System.out.println(sqrtDouble.getSqrtDoubleBinarySearch(0.1));

    }
}
