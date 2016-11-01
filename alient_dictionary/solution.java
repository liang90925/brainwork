import java.util.*;

public class Solution {
  private static final int N = 26;

  public class Node{
    private char name;
    private int inDegree;
    private List<Node> nexts;
    public Node(char name, int inDegree) {
      this.name = name;
      this.inDegree = inDegree;
      this.nexts = new ArrayList<>();
    }
  }

  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) {
      return "";
    }

    Node[] nodes = new Node[N];
    for (int i = 0; i < N; i++) {
      nodes[i] = new Node(toChar(i), 0);
    }

    boolean[] existedNodes = new boolean[N];

    int wordsCount = words.length;

    for (int i = 0; i < wordsCount; i++) {
      String currW = words[i];
      int currWLen = currW.length();

      for (int j = 0; j < currWLen; j++) {
        existedNodes[toInt(currW.charAt(j))] = true;
      }

      if (i != wordsCount - 1) {
        int endPoint = -1;
        String nextW = words[i + 1];
        int nextWLen = nextW.length();
        int minLen = Math.min(currWLen, nextWLen);

        for (int j = 0; j < minLen; j++) {
          if (currW.charAt(j) != nextW.charAt(j)) {
            endPoint = j;
            break;
          }
        }

        if (endPoint == -1 && currWLen > nextWLen) {
          return "";
        }

        if (endPoint != -1) {
          int nextWInx = toInt(nextW.charAt(endPoint));
          int currWInx = toInt(currW.charAt(endPoint));
          nodes[nextWInx].inDegree++;
          nodes[currWInx].nexts.add(nodes[nextWInx]);
        }
      }
    }

    Queue<Node> que = new LinkedList<>();
    String result = "";

    for (int i = 0; i < N; i++) {
      if (existedNodes[i] && nodes[i].inDegree == 0) {
        que.offer(nodes[i]);
        result += nodes[i].name;
      }
    }

    while (!que.isEmpty()) {
      Node currN = que.poll();
      for (Node node : currN.nexts) {
        node.inDegree--;
        if (node.inDegree == 0) {
          que.offer(node);
          result += node.name;
        }
      }
    }

    for (Node node : nodes) {
      if (node.inDegree != 0) {
        return "";
      }
    }

    return result;
  }

  private char toChar(int i) {
    return (char) ('a' + i);
  }

  private int toInt(char c) {
    return c - 'a';
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] words = {  "wrt", "wrf", "er", "ett", "rftt"};
    String result = solution.alienOrder(words);
    System.out.println(result);
  }
}
