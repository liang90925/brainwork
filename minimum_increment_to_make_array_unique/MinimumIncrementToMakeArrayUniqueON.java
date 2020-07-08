import java.util.Arrays;

public class MinimumIncrementToMakeArrayUniqueON {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int ans = 0;
        int taken = 0;
        int[] counts = new int[100000];

        for (int a: A) {
            counts[a]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1) {
                int extra = counts[i] - 1;
                taken += extra;
                ans -= i * extra;

            } else {
                // move the duplicated extra ones to the empty space
                if (taken > 0 && counts[i] == 0) {
                    taken--;
                    ans += i;
                }
            }
        }

        return ans;
    }
}
