import java.util.*;

public class ConsistentHashing {
    public ConsistentHashing() {
    }

    /*
     * @param n: a positive integer
     * @return: n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>(Arrays.asList(0, 359, 1)));
        int currMax = 0;

        for (int i = 2; i <= n; i++) {
            List<Integer> currMaxList = results.get(currMax);
            int start = currMaxList.get(0);
            int end = currMaxList.get(1);
            int mid = (start + end) / 2;
            results.remove(currMax);
            results.add(currMax, new ArrayList<>(Arrays.asList(start, mid, currMaxList.get(2))));
            results.add(currMax + 1, new ArrayList<>(Arrays.asList(mid + 1, end, i)));

            int maxRingVal = 0;
            for (int j = 0; j < results.size(); j++) {
                int ringVal = results.get(j).get(1) - results.get(j).get(0) + 1;
                if (ringVal > maxRingVal) {
                    maxRingVal = ringVal;
                    currMax = j;
                } else if (maxRingVal == ringVal) {
                    if (results.get(j).get(2) < results.get(currMax).get(2)) {
                        currMax = j;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ConsistentHashing solution = new ConsistentHashing();
        System.out.println(solution.consistentHashing(1));
        System.out.println(solution.consistentHashing(2));
        System.out.println(solution.consistentHashing(3));
        System.out.println(solution.consistentHashing(4));
    }
}