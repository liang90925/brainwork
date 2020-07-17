import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfIslandII {
  private int[] X_AXIS = {-1, 1, 0, 0};
  private int[] Y_AXIS = {0, 0, -1, 1};
  public List<Integer> numIslands2(int m, int n, int[][] positions) {

    if (m == 0 || n == 0 || positions == null || positions.length == 0 || positions[0].length == 0) {
      return Collections.emptyList();
    }

    int[] root = new int[m * n];
    //NOTE!! USE Arrays.fill to assign -1 to all element in root;
    Arrays.fill(root , -1);

    List<Integer> result = new ArrayList<>();

    int count = 0;
    for (int i = 0; i < positions.length; i++) {
      count++;
      int x = positions[i][0];
      int y = positions[i][1];
      int index = x * m + y;
      root[index] = index;
      for (int j = 0; j < 4; j++) {
        int newX = x + X_AXIS[j];
        int newY = y + Y_AXIS[j];
        int newIndex = newX * m + newY;
        if (newX < 0 || newX >= m || newY < 0 || newY >= n || root[newIndex] == -1) {
          continue;
        }
        int newRoot = find(root, newIndex);
        if (newRoot != index) {
          root[newRoot] = index;
          count--;
        }
      }
      result.add(count);
    }
    return result;
  }

  private int find(int[] root, int i) {
    while (root[i] != i) {
      root[i] = root[root[i]];
      i = root[i];
    }
    return i;
  }
}
