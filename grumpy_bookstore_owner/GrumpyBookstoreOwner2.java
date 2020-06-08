public class GrumpyBookstoreOwner2 {
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
        int satisfiedSum = 0;
        for (int i = 0; i < customersLen; i++) {
            if (grumpy[i] == 0) {
                satisfiedSum += customers[i];
            }
        }

        int maxTurnedSum = 0;
        int turnedSum = 0;
        int left = 0;
        for (int right = 0; right < customersLen; right++) {
            if (grumpy[right] == 1) {
                turnedSum += customers[right];
            }

            if (right - left + 1 > X) {
                if (grumpy[left] == 1) {
                    turnedSum -= customers[left];
                }
                left++;
            }
            maxTurnedSum = Math.max(maxTurnedSum, turnedSum);
        }
        return satisfiedSum + maxTurnedSum;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner2 grumpyBookstoreOwner = new GrumpyBookstoreOwner2();
        System.out.println(grumpyBookstoreOwner.maxSatisfied(
                new int[]{1,0,1,2,1,1,7,5},
                new int[]{0,1,0,1,0,1,0,1},
                3) + " === 16");
    }
}
