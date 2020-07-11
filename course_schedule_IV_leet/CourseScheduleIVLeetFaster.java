import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIVLeetFaster {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] hs = new boolean[n][n];
        for(int[] p : prerequisites){
            hs[p[0]][p[1]]=true;
        }

        boolean[] visit = new boolean[n];
        for(int i=0; i<n; ++i) {
            dfs(hs, visit, i);
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries){
            res.add(hs[q[0]][q[1]]);
        }
        return res;
    }
    private void dfs(boolean[][] hs, boolean[] visit, int idx){
        if(visit[idx]) {
            return;
        }

        visit[idx]=true;
        boolean[] tem = new boolean[hs.length];

        for (int i=0; i<hs.length; ++i){
            if (hs[idx][i]) {
                dfs(hs, visit, i);
                for (int j=0; j < hs.length; ++j) {
                    if (hs[i][j]) {
                        tem[j] = true;
                    }
                }
            }
        }
        for(int j=0; j<hs.length; ++j) {
            if(tem[j]) {
                hs[idx][j]=true;
            }
        }
    }
}
