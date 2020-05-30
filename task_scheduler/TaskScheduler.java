import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n <= 0) {
            return tasks.length;
        }

        int[] taskCnt = new int[256];
        int maxCnt = 0;
        for (char ch: tasks) {
            if (taskCnt[ch] == 0) {
                taskCnt[ch] = 1;
            } else {
                taskCnt[ch]++;
            }
            maxCnt = Math.max(taskCnt[ch], maxCnt);
        }

        int totalInterval = (maxCnt -1) * (n + 1);
        for (int i = 0; i < 256; i++) {
            if (taskCnt[i] == maxCnt) {
                totalInterval -= (maxCnt - 1);
            } else if (taskCnt[i] > 0) {
                totalInterval -= taskCnt[i];
            }
        }

        // this is for AAAAAABCDEFG;
        return Math.max(totalInterval, 0) + tasks.length;
    }

    public static void main(String[] args) {
        TaskScheduler solution = new TaskScheduler();

        System.out.println("====================");
        String tasks = "AAABBB";
        int n = 2;
        System.out.println("task: " + tasks);
        System.out.println("n: " + n);
        System.out.println("result: " + solution.leastInterval(tasks.toCharArray(), n));

        System.out.println("====================");
        String tasks1 = "AAABBBCCC";
        int n1 = 2;
        System.out.println("task: " + tasks1);
        System.out.println("n: " + n1);
        System.out.println("result: " + solution.leastInterval(tasks1.toCharArray(), n1));

        System.out.println("====================");
        String tasks2 = "AAAAABBBBBCD";
        int n2 = 3;
        System.out.println("task: " + tasks2);
        System.out.println("n: " + n2);
        System.out.println("result: " + solution.leastInterval(tasks2.toCharArray(), n2));

        System.out.println("====================");
        String tasks3 = "AAAAAABCDEFG";
        int n3 = 1;
        System.out.println("task: " + tasks3);
        System.out.println("n: " + n3);
        System.out.println("result: " + solution.leastInterval(tasks3.toCharArray(), n3));
    }
}
