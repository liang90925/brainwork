public class Solution {
    private static int N = 26;
  // build a new class to hold info we need
    public static class Node {
      private int degree;
      private List<Integer> nextNodes;

      public void Node() {
        this.degree = 0;
      }
    }

    public static String alienOrder(String[] words) {
      // create an Node array that holds 26 Nodes
      Node[] node = new Node[N];
      // initiate the node
      for (int i = 0; i < N; i++) {
        node[i] = new Node();
      }

      // create an array to record the letters showed up in the input
      boolean[] existed = new boolean[N];

      // build the graph
      for (int i = 0; i < words.length; i++) {
        int startPoint = 0, endPoint = 0;
        // loop the current words[i] and add it to existed array
        for (int j = 0 ; j < words[i].length(); j++) {
          existed[charToInt(words[i].charAt(j))] = true;
        }

        if (i != words.length - 1) {
          for (int k = 0; k < Math.min(words[i].length(), words[i + 1].length()); k++) {
            if (words[i].charAt(k) != words[i + 1].charAt(k)) {
              startPoint = charToInt(words[i].charAt(k));
              endPoint = charToInt(words[i + 1].charAt(k));
              break;
            }
          }
        }
        if (startPoint != endPoint) {
          System.out.println("startPoint: " + startPoint);
          if (node[startPoint].nextNodes == null) {
            node[startPoint].nextNodes = new ArrayList<>();
          }
          node[startPoint].nextNodes.add(endPoint);
          node[endPoint].degree++;
        }
      }

      // topology sort
      Queue<Integer> inxQue = new LinkedList<>();
      String ans = "";

      for (int i = 0; i < N; i++) {
        // find the 0 degree node saw in the input and put them to queue;
        if (node[i].degree == 0 && existed[i]) {
          inxQue.offer(i);
          ans = ans + intToChar(i);
        }
      }

      while (!inxQue.isEmpty()) {
        int currInx = inxQue.poll();
        if (node[currInx].nextNodes != null) {
          for (int i : node[currInx].nextNodes) {
            node[i].degree--;
            if (node[i].degree == 0) {
              inxQue.offer(i);
              ans = ans + intToChar(i);
            }
          }
        }
      }
      for (int i = 0; i < N; i++) {
        if (node[i].degree != 0) {
          return "";
        }
      }
      return ans;
    }
    // first build the map;
    // using topology sort to get the result;

    private static int charToInt(char c) {
      return c - 'a';
    }

    private static char intToChar(int i) {
      return (char) ('a' + i);
    }
}
