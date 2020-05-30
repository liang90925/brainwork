import jdk.internal.org.objectweb.asm.tree.FrameNode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ConsistentHashingII {
    /*
     * @param n: a positive integer
     * @param k: a positive integer
     * @return: a Solution object
     */

    public class Point {
        private int machineId;
        private int value;

        public Point(int machineId, int value) {
            this.machineId = machineId;
            this.value = value;
        }
    }
    private final int range;
    private final int randomCnt;
    private Set<Integer> usedPoints = new HashSet<>();
    private List<Point> points = new ArrayList<>();
    private Random random = new Random();

    private ConsistentHashingII(int range, int randomCnt) {
        this.range = range;
        this.randomCnt = randomCnt;
    }
    public static ConsistentHashingII create(int n, int k) {
        // Write your code here
        return new ConsistentHashingII(n, k);
    }

    /*
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
        // write your code here
        List<Integer> hashList = new ArrayList<>();
        for (int i = 0; i < randomCnt; i++) {
            int currRandom = random.nextInt(range);
            while(usedPoints.contains(currRandom)) {
                currRandom = random.nextInt(range);
            }
            usedPoints.add(currRandom);
            hashList.add(currRandom);
            points.add(new Point(machine_id, currRandom));
        }
        return hashList;
    }

    /*
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
        // write your code here
        points.sort(Comparator.comparingInt(p -> p.value));
        for (int i = 0; i < points.size() - 1; i++) {
            Point prevPoint = points.get(i);
            Point nextPoint = points.get(i + 1);
            if (hashcode == prevPoint.value) {
                return prevPoint.machineId;
            }
            if (hashcode > prevPoint.value && hashcode <= nextPoint.value) {
                return nextPoint.machineId;
            }
        }
        return points.get(0).machineId;
    }

    public static void main(String[] args) {
        ConsistentHashingII solution = new ConsistentHashingII(10, 5);
        System.out.println(solution.addMachine(1));
        System.out.println(solution.getMachineIdByHashCode(4));
        System.out.println(solution.addMachine(2));
        System.out.println(solution.getMachineIdByHashCode(0));
        System.out.println(solution.getMachineIdByHashCode(1));
        System.out.println(solution.getMachineIdByHashCode(2));
        System.out.println(solution.getMachineIdByHashCode(3));
        System.out.println(solution.getMachineIdByHashCode(4));
        System.out.println(solution.getMachineIdByHashCode(5));

        System.out.println("==================");
        ConsistentHashingII solution1 = new ConsistentHashingII(100, 3);
        System.out.println(solution1.addMachine(1));
        System.out.println(solution1.getMachineIdByHashCode(4));
        System.out.println(solution1.addMachine(2));
        System.out.println(solution1.getMachineIdByHashCode(61));
        System.out.println(solution1.getMachineIdByHashCode(91));


    }
}