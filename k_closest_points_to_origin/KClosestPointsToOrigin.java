import java.util.Arrays;

// solution 1: divide and conqure
public class KClosestPointsToOrigin {
  public int[][] kClosest(int[][] points, int K) {
    int pointsLen = points.length;
    quickSort(points, 0, pointsLen - 1, K);
    return Arrays.copyOfRange(points, 0, K);
  }

  public void quickSort(int[][] points, int left, int right, int K) {
    if (left == right) {
      return;
    }
    // Find pivot
    int pivot = partition(points, left, right);

    // Go to left or right to to further quicksort
    int leftLen = pivot - left + 1;
    // 0-K is in both left and right range
    if (leftLen < K) {
      quickSort(points, pivot + 1, right, K - leftLen);
    }
    // 0-K is with in the left range
    if (leftLen > K) {
      quickSort(points, left, pivot - 1, K);
    }
  }

  public int partition(int[][] points, int left, int right) {
    // set pivot to the value on the left of the array;
    int pivotInx = left;
    int pivotDis = distance(points[pivotInx]);
    // Starts from the one on the right side of the first value;
    int i = left + 1;
    int j = right;

    while (true) {
      // One the right side; Find the index that has distance <= pivotDis
      while (j > left && (distance(points[j]) >= pivotDis)) {
        j--;
      }
      // One the left side; Find the index that has distance >= pivotDis
      while (i < right && (distance(points[i]) <= pivotDis)) {
        i++;
      }

      if (i >= j) {
        break;
      }
      swap(points, i, j);

    }
    swap(points, pivotInx, j);
    return j;
  }

  public void swap(int[][] points, int i, int j) {
    int[] temp = points[i];
    points[i] = points[j];
    points[j] = temp;
  }

  public int distance(int[] point) {
    return point[0]*point[0] + point[1]*point[1];
  }

  private String toString(int[][] points) {
    StringBuilder output = new StringBuilder();
    output.append("{");
    for (int[] point : points) {
      output.append("{")
              .append(point[0]).append(",").append(point[1])
//              .append(" (").append(getDistance(point)).append(")],");
              .append("},");
    }
    output.append("}");
    return output.toString();
  }

  public static void main(String[] args) {
//    System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest(
//            new int[][] {{-5,4},{-3,2},{0,1},{-3,7},{-2,0},{-4,-6},{0,-5}}, 6)));
//    System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest(
//            new int[][] {{-5,4},{-3,2},{0,1},{-3,7},{-2,0},{-4,-6},{0,-5}}, 6)));

//    {
//      int[][] points = new int[][]{{-2, 0}, {-3, 2}, {0, 1}, {0, -5}, {-5, 4}, {-4, -6}, {-3, 7}};
//      int pivot = new KClosestPointsToOrigin().partition(points, 5, 6);
//      System.out.println("pivot: " + pivot);
//      System.out.println(Arrays.deepToString(points));
//      System.out.println("-------");
//    }

//    {
//      int[][] points = new int[][]{{-4, -6}, {-3, 7}};
//      int pivot = new KClosestPointsToOrigin().partition(points, 0, 1);
//      System.out.println("pivot: " + pivot);
//      System.out.println(Arrays.deepToString(points));
//      System.out.println("-------");
//    }

    int[][] points = new int[][]{
//            {1, -3}, {2, 2}, {1, 2}, {2, 3}, {2, 1}
//            // 10, 8, 5, 13, 5
            {1, -3}, {2, 2}
//            // 10, 8
//            {6,10},{-3,3},{-2,5},{0,2}

            // 136, 18, 29, 4
    };

    System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest(points, 1)));

//    int pivot = new KClosestPointsToOrigin().partition(points, 0, 3);
//    System.out.println("pivot: " + pivot);
//    System.out.println(Arrays.deepToString(points));
//    System.out.println("-------");
//
//    int pivot2 = new KClosestPointsToOrigin().partition(points, 0, 2);
//    System.out.println("pivot: " + pivot2);
//    System.out.println(Arrays.deepToString(points));
//
//    System.out.println("-------");
//    int pivot3 = new KClosestPointsToOrigin().partition(points, 1, 2);
//    System.out.println("pivot: " + pivot3);
//    System.out.println(Arrays.deepToString(points));
//
//    System.out.println("-------");
//    int pivot4 = new KClosestPointsToOrigin().partition(points, 2, 2);
//    System.out.println("pivot: " + pivot4);
//    System.out.println(Arrays.deepToString(points));
  }
}