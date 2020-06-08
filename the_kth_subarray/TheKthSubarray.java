import java.util.Arrays;

public class TheKthSubarray {

    /**
     * @param a: an array
     * @param k: the kth
     * @return: return the kth subarray
     */
    public long thekthSubarray(int[] a, long k) {
        // write your code here

        int len = a.length;
        if (len == 0 || k <= 0) {
            return 0;
        }

        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i];
        }
        long left = 0;
        long right = sum;
        while (left < right - 1) {
            long mid = left + (right - left) / 2;
            if (getRankingAtMid(a, mid) >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (getRankingAtMid(a, left) >= k) {
            return left;
        } else {
            return right;
        }
    }

    public long getRankingAtMid(int[] a, long targetSum) {
        long len = a.length;
        long largerThanTarget = 0;
        int start = 0;
        int end = 0;
        long sum = a[start];
        while (start < len) {
            while (sum <= targetSum) {
                end++;
                if (end >= len) {
                    break;
                }
                sum += a[end];
            }
            if(end < len) {
                largerThanTarget += len - end;
            }

            sum -= a[start];
            start = start + 1;
        }
        return len * (len + 1) / 2 - largerThanTarget;
    }

    public static void main(String[] args) {
        TheKthSubarray solution = new TheKthSubarray();
        System.out.println(solution.thekthSubarray(new int[]{2,3,1,4}, 6));
    }
}
