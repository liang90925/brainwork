import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class KClosestPointsToOrigin2 {
  public int[][] kClosest(int[][] points, int K) {
    int pointsLen = points.length;
    int[] distances = new int[pointsLen];

    for (int i = 0; i < pointsLen; i++) {
      distances[i] = distance(points[i]);
    }
    Arrays.sort(distances);
    int kPointDis = distances[K - 1];
    int[][] results = new int[K][2];
    // This array list to track the case when distance array like that [1,2,3,3,3,3,3,3], and k = 4,  we won't return [3,3,3,3]
    List<Integer> sameKDisIdx = new ArrayList<>();
    int j = 0;
    for (int i = 0, k = 0; i < pointsLen; i++) {
      if (distance(points[i]) < kPointDis) {
        if (k == K) {
          results[j] = points[i];
          j++;
        } else {
          results[k] = points[i];
          k++;
        }
      }
      if (distance(points[i]) == kPointDis) {
        sameKDisIdx.add(i);
        if (k < K) {
          results[k] = points[i];
          k++;
        }
      }
    }

    return results;
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
            {1, -3}, {2, 2}, {2, -2}, {-2, 2}, {-2, -2}, {1, 1}
//            // 10, 8
//            {6,10},{-3,3},{-2,5},{0,2}

            // 136, 18, 29, 4
    };

    System.out.println(Arrays.deepToString(new KClosestPointsToOrigin2().kClosest(points, 3)));

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