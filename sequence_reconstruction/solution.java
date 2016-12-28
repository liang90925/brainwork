import java.util.*;

public class Solution {
  class Node {
    Set<Integer> next;
    int inDegree;

    Node() {
      inDegree = 0;
      next = new HashSet<>();
    }
  }

  public boolean sequenceReconstruction(int[] org, int[][] seqs) {
    Map<Integer, Node> graph = new HashMap<>();
    // build graph
    for (int[] seq : seqs) {
      if (seq.length == 1) {
        if (!graph.containsKey(seq[0])) {
          graph.put(seq[0], new Node());
        }
      } else {
        for (int i = 0; i < seq.length - 1; i++) {
          // put seq[i] to map
          if (!graph.containsKey(seq[i])) {
            graph.put(seq[i], new Node());
          }

          // put seq[i + 1] to map
          if (!graph.containsKey(seq[i + 1])) {
            graph.put(seq[i + 1], new Node());
          }

          // check if seq[i + 1] are in next of seq[i] node
          if (!graph.get(seq[i]).next.contains(seq[i + 1])) {
            graph.get(seq[i]).next.add(seq[i + 1]);
            graph.get(seq[i + 1]).inDegree++;
          }
        }
      }
    }

    // topology sort
    // 1. find all indegree = 0 node
    Queue<Integer> que = new LinkedList<>();
    for (Map.Entry<Integer, Node> entry : graph.entrySet()) {
      if (entry.getValue().inDegree == 0) {
        que.offer(entry.getKey());
      }
    }

    int[] newOrg = new int[org.length];
    int index = 0;
    while (!que.isEmpty()) {
      int size = que.size();
      if (size > 1) {
        return false;
      }
      int curr = que.poll();
      if (index >= org.length || org[index++] != curr) {
        return false;
      }

      for (int nextInteger : graph.get(curr).next) {
        graph.get(nextInteger).inDegree--;
        if (graph.get(nextInteger).inDegree == 0) {
          que.offer(nextInteger);
        }
      }
    }

    for (Map.Entry<Integer, Node> entry : graph.entrySet()) {
      if (entry.getValue().inDegree != 0) {
        return false;
      }
    }

    return index == org.length && index == graph.size();
  }
}
