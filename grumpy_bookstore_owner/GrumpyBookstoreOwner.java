public class GrumpyBookstoreOwner {
    /**
     * @param customers: the number of customers
     * @param grumpy: the owner's temper every day
     * @param X: X days
     * @return: calc the max satisfied customers
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // write your code here

        int customersLen = customers.length;
        int grumpyLen = grumpy.length;
        if (customersLen == 0 || grumpyLen == 0) {
            return 0;
        }

        int sumLen = customersLen - X + 1;
        int[] nonGrumpySumLeft = new int[customersLen - X + 1];
        int[] nonGrumpySumRight = new int[customersLen - X + 1];
        nonGrumpySumLeft[0] = 0;
        nonGrumpySumRight[sumLen - 1] = 0;

        int sum = 0;
        for (int i= 0; i < sumLen - 1; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }

            nonGrumpySumLeft[i + 1] = sum;
        }

        sum = 0;
        for (int i = customersLen - 1; i >= X; i--) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
            nonGrumpySumRight[i - X] = sum;
        }

        int[] xSum = new int[sumLen];
        int tempXSum = 0;
        for (int i = 0; i < customersLen; i++) {
            if (i < X - 1) {
                tempXSum += customers[i];
                continue;
            }
            tempXSum += customers[i];
            if (i >= X) {
                tempXSum -= customers[i - X];
            }
            xSum[i - X + 1] = tempXSum;
        }

        int result = 0;
        for (int i = 0; i < sumLen; i++) {
            int currResult = nonGrumpySumLeft[i] + xSum[i] + nonGrumpySumRight[i];
            result = Math.max(result, currResult);
        }

        return result;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner grumpyBookstoreOwner = new GrumpyBookstoreOwner();
        System.out.println(grumpyBookstoreOwner.maxSatisfied(
                new int[]{1,0,1,2,1,1,7,5},
                new int[]{0,1,0,1,0,1,0,1},
                3));
    }
}
