import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIVLeetN3 {

    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        List<Boolean> answers = new ArrayList<>();
        boolean[][] map = new boolean[n][n];
        for (int[] i : pre) map[i[0]][i[1]] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i]) {
                    for (int k = 0; k < n; k++)
                        if (map[i][k]) map[j][k] = true;
                }
            }
        }

        for (int[] i : queries) answers.add(map[i[0]][i[1]]);
        return answers;
    }
}
