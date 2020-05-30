import java.util.*;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (logs.size() <= 1) {
            return result;
        }

        int sum = 0;
        Stack<Integer> logIdxStk = new Stack<>();
        logIdxStk.add(0);
        for (int i = 1; i < logs.size(); i++) {
            String[] logSplit = logs.get(i).split(":");

            int idx = Integer.parseInt(logSplit[0]);
            String action = logSplit[1];
            int time = Integer.parseInt(logSplit[2]);

            if (action.equals("start")) {
                if (!logIdxStk.isEmpty()) {
                    int prevIdx = logIdxStk.peek();
                    result[prevIdx] += time - sum;
                    sum = time;
                }
                logIdxStk.add(idx);
            } else {
                // "end"
                result[idx] +=  time + 1 - sum;
                sum = time + 1;
                logIdxStk.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ExclusiveTimeOfFunctions solution = new ExclusiveTimeOfFunctions();

        int n = 2;
        String[] logs = new String[]{"0:start:0","1:start:2","1:end:5","0:end:6"};
        System.out.println("n: " + n + "    logs: " + Arrays.toString(logs));
        System.out.println(Arrays.toString(solution.exclusiveTime(n, Arrays.asList(logs))));

        System.out.println("=====================");
        int n1 = 8;
        String[] logs1 = new String[]{"0:start:0", "1:start:5", "2:start:6", "3:start:9", "4:start:11", "5:start:12", "6:start:14", "7:start:15", "1:start:24", "1:end:29", "7:end:34", "6:end:37", "5:end:39", "4:end:40", "3:end:45", "0:start:49", "0:end:54", "5:start:55", "5:end:59", "4:start:63", "4:end:66", "2:start:69", "2:end:70", "2:start:74", "6:start:78", "0:start:79", "0:end:80", "6:end:85", "1:start:89", "1:end:93", "2:end:96", "2:end:100", "1:end:102", "2:start:105", "2:end:109", "0:end:114"};
        System.out.println("n: " + n1 + "    logs: " + Arrays.toString(logs1));
        System.out.println(Arrays.toString(solution.exclusiveTime(n1, Arrays.asList(logs1))));

        System.out.println("=====================");
        int n2 = 1;
        String[] logs2 = new String[]{"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
        System.out.println("n: " + n2 + "    logs: " + Arrays.toString(logs2));
        System.out.println(Arrays.toString(solution.exclusiveTime(n2, Arrays.asList(logs2))));


        System.out.println("=====================");
        int n3 = 3;
        String[] logs3 = new String[]{"0:start:0","0:end:0","1:start:1","1:end:2","2:start:4","2:end:6"};
        System.out.println("n: " + n3 + "    logs: " + Arrays.toString(logs3));
        System.out.println(Arrays.toString(solution.exclusiveTime(n3, Arrays.asList(logs3))));

    }
}
