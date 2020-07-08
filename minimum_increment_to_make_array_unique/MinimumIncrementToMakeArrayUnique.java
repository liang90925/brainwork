import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        Arrays.sort(A);

        int ans = 0;
        int max = A[0];
        for (int i = 0; i < len; i++) {
            ans += Math.max(0, max - A[i]);
            max = Math.max(max + 1, A[i] + 1);
        }

        return ans;
    }
}
