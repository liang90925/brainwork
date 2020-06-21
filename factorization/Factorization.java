import java.util.ArrayList;
import java.util.List;

public class Factorization {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        dfs(2, n, new ArrayList<>(), results);
        return results;
    }


    private void dfs(int start, int remain, List<Integer> path, List<List<Integer>> results) {
        if (remain == 1) {
            if (path.size() != 1) {
                results.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= remain; i++) {
            if (i > remain / i) {
                break;
            }
            if (remain % i  == 0) {
                path.add(i);
                dfs(i, remain / i, path, results);
                path.remove(path.size() - 1);
            }
        }
        path.add(remain);
        dfs(remain, 1, path, results);
        path.remove(path.size() - 1);
    }
}
