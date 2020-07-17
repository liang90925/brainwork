import java.util.Random;

public class RandomPickWithWeight {
    private int sum = 0;
    private final int[] prefixSum;
    public RandomPickWithWeight(int[] w) {
        prefixSum = new int[w.length];

        for(int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }

    public int pickIndex() {
        double target = this.sum * Math.random();
        for (int i = 0; i < prefixSum.length; i++) {
            if (target < prefixSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
