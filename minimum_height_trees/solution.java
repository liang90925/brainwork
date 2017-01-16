// 用类似于topology sort的方法，逐层删掉

public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n <= 0 || edges ==  null) {
      return Collections.emptyList();
    }
    // for case, n=1, edges = [], we should return [0], instead of []
    if (n == 1) return Collections.singletonList(0);

    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(i, new HashSet<>());
    }
    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      map.get(from).add(to);
      map.get(to).add(from);
    }

    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if(map.get(i).size() == 1) {
        leaves.add(i);
      }
    }

    while (n > 2) {
      List<Integer> newLeaves = new ArrayList<>();
      for (int leaveNode : leaves) {
        n--;
        int leaveNeighbor = map.get(leaveNode).iterator().next();
        // remove the leaveNode from it's neighbors's neighor list
        map.get(leaveNeighbor).remove(leaveNode);
        if (map.get(leaveNeighbor).size() == 1) {
          newLeaves.add(leaveNeighbor);
        }
      }
      leaves = newLeaves;
    }
    return leaves;
  }
}
