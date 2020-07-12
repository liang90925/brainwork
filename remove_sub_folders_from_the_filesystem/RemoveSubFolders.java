import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFolders {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        int i = 0;
        String curr = folder[i];
        result.add(curr);
        while (++i < folder.length) {
            String next = folder[i];
            if (!next.contains(curr + '/')) {
                result.add(next);
                curr = next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveSubFolders solution = new RemoveSubFolders();
        System.out.println(solution.removeSubfolders(
                new String[]{
                        "/a","/a/b","/c/d","/c/d/e","/c/f"
                }
        ) + " === [\"/a\",\"/c/d\",\"/c/f\"]");

        System.out.println(solution.removeSubfolders(
                new String[]{
                        "/a","/a/b/c","/a/b/d"
                }
        ) + " === [\"/a\"]");

        System.out.println(solution.removeSubfolders(
                new String[]{
                        "/a/b/c","/a/b/ca","/a/b/d"
                }
        ) + " === [\"/a/b/c\",\"/a/b/ca\",\"/a/b/d\"]");
    }
}
