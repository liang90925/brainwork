
subarray 使用前缀和

Sum[0] = 0;
sum[i] = nums[0] + nums[1] + ...+ nums[i - 1];
任意一段subarray的和为sum[i] - sum[j - 1]
任意一段subarray的平均值是（sum[i] - sum[j - 1]）/ (i - j + 1)


public class Solution {
  public double maxAverage(int[] nums, int k) {
    double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      l = Math.min(l, nums[i]);
      r = Math.max(r, nums[i]);
    }

    double[] sum = new double[n + 1];
    sum[0] = 0;
    while (r - l >= 1e-6) {
      doulbe mid = (l + r) / 2.0;
      boolean check = false;
      //nums[i] = nums[i] -x
      // min_pre 表示最小前缀
      double min_pre = 0;
      for (int i = 1; i <= n; i++) {
        sum[i] = sum[i - 1] + nums[i - 1] - mid;
        // 0<= j <= i - k + 1;
        //if (sum[i] - sum[j - 1] >= 0 && (i - j + 1) >= k) {
        if (sum[i] - min_pre >= 0 && i >= k) {
          check = true;
          break;
        }
        if (i >= k) {
          min_pre = Math.min(min_pre, sum[i - k + 1]);
        }
        if (check) {
          l = mid;
        } else {
          r = mid;
        }
      }
    }
    return r;
  }
}
