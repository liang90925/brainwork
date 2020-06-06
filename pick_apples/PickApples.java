import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.util.Arrays;

public class PickApples {
    /**
     * @param A: a list of integer
     * @param K: a integer
     * @param L: a integer
     * @return: return the maximum number of apples that they can collect.
     */
    public int PickApples(int[] A, int K, int L) {

        // write your code here
        int len = A.length;
        if (K + L > len) {
            return -1;
        }
        // Calculate the max of K starting from 0
        int[] prefixKSum = getPrefixSum(A, len, K);
        int[] prefixLSum = getPrefixSum(A, len, L);
        int[] postfixKSum = getPostfixSum(A, len, K);
        int[] postfixLSum = getPostfixSum(A, len, L);

        int max = -1;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, prefixKSum[i] + postfixLSum[i + 1]);
            max = Math.max(max, prefixLSum[i] + postfixKSum[i + 1]);
        }
        return max;
    }

    private int[] getPrefixSum(int[] A, int ALen, int subLen) {
        int[] prefixSum = new int[ALen];
        int max = 0;
        int currSum = 0;
        for (int i = 0; i < ALen; i++) {
            if (i < subLen - 1) {
                currSum += A[i];
                prefixSum[i] = 0;
                continue;
            }
            currSum += A[i];
            if (i - subLen >= 0) {
                currSum -= A[i -subLen];
            }
            max = Math.max(max, currSum);
            prefixSum[i] = max;
        }
        return prefixSum;
    }

    private int[] getPostfixSum(int[] A, int ALen, int subLen) {
        int[] postfixSum = new int[ALen];
        int max = 0;
        int currSum = 0;
        for (int i = ALen - 1; i >= 0; i--) {
            if (i > ALen - subLen) {
                currSum += A[i];
                postfixSum[i] = 0;
                continue;
            }
            currSum += A[i];
            if (i + subLen < ALen) {
                currSum -= A[i + subLen];
            }
            max = Math.max(max, currSum);
            postfixSum[i] = max;
        }
        return postfixSum;
    }

    public static void main(String[] args) {
        PickApples pickApples = new PickApples();

        System.out.println(pickApples.PickApples(new int[]{6, 1, 4, 6, 3, 2, 7, 4}, 3, 2));
    }


}
