import java.util.*;

public class CourseScheduleIVLeetN2 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] P, int[][] Q) {
        Map<Integer, Set<Integer>> parsOfKey = new HashMap<>();
        Map<Integer, Set<Integer>> kidsOfKey = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parsOfKey.put(i, new HashSet<>());
            kidsOfKey.put(i, new HashSet<>());
        }
        //update each prereq relation
        for (int[] i : P) {
            parsOfKey.get(i[1]).add(i[0]);
            for (int j : parsOfKey.get(i[0])) {
                parsOfKey.get(i[1]).add(j);
            }
            kidsOfKey.get(i[0]).add(i[1]);
            for (int m : kidsOfKey.get(i[1])) {
                kidsOfKey.get(i[0]).add(m);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : Q) {
            // check if there's a relation between the nodes in either map
            ans.add(parsOfKey.get(q[1]).contains(q[0]) || kidsOfKey.get(q[0]).contains(q[1]));
        }
        return ans;
    }
}
