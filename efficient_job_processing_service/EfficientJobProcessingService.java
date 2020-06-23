public class EfficientJobProcessingService {
    /**
     * @param n: the number of tasks
     * @param weights: the weight for every task
     * @param tasks: the actual duration of every task
     * @param p: maximum runtime for Pigeon in an hour
     * @return: the maximum total weight that the Pigeon service can achieve in an hour
     */
    public int maxWeight(int n, int[] weights, int[] tasks, int p) {
        // write your code here
        if (n <= 0) {
            return 0;
        }

        int halfTasks = p/2;
        int[] sum = new int[halfTasks + 1];

        for (int i = 0; i < n; i++) {
            int weight = weights[i];
            int task = tasks[i];

            for (int j = halfTasks; j >= task; j--) {
                sum[j] = Math.max(sum[j], weight + sum[j - task]);
            }
        }
        return sum[halfTasks];
    }
}
