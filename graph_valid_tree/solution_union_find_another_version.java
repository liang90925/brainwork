// union find solution

public class Solution {
  public boolean validTree(int n, int[][] edges) {
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < edges.length; i++) {
      // 如果两个节点已经在同一集合中，说明新的边将产生环路
      if (!uf.union(edges[i][0], edges[i][1])) {
        return false;
      }
    }
    return uf.count() == 1;
  }

  public class UnionFind {
    private int[] root;
    private int count;

    public UnionFind(int n) {
      this.count = n;
      this.root = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
    }

    public boolean union(int m, int n) {
      int root1 = find(m);
      int root2 = find(n);

      //如果两个节点不在同一集合中，将两个集合合并为一个
      if (root1 != root2) {
        for (int i = 0; i < root.length; i++) {
          if (root[i] == root1) {
              root[i] = root2;;
          }
        }
        // 合并完集合后，集合数减一
        count--;
        return true;
      } else {
        return false;
      }
    }

    public int find (int m) {
      return root[m];
    }

    public boolean areConnected(int m, int n){
      return find(m) == find(n);
    }

    public int count(){
      return cnt;
    }
  }
}
