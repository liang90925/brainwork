import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeightBS {
    Random random = new Random();
    private int sum = 0;
    private final int[] prefixSum;
    public RandomPickWithWeightBS(int[] w) {
        prefixSum = new int[w.length];

        for(int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }

    public int pickIndex() {
        double target = this.sum * Math.random();
        return binarySearch(target);
        // The above solution implement our own binary search

        // The following utilized the binarySearch of the Arrays
//        int target = random.nextInt(sum) + 1;
//
//        int idx = Arrays.binarySearch(prefixSum, target);
//        if (idx < 0) {
//            idx = -1 * idx - 1;
//        }
//        return idx;
    }

    private int binarySearch(double target) {
        int left = 0;
        int right = prefixSum.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
