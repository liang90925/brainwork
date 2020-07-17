import java.util.*;

public class WordSearchIIRewrite {
  private static final int[][] RANGE = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public List<String> findWords(char[][] board, String[] words) {
    if (words == null || words.length == 0) {
      return Collections.emptyList();
    }
    if (board == null || board.length == 0) {
      return Collections.emptyList();
    }

    Trie trie = new Trie();
    for (String word: words) {
      trie.insert(word);
    }

    List<String> results = new ArrayList<>();

    int r = board.length;
    int c = board[0].length;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (trie.root.subs.containsKey(board[i][j])) {
          searchWord(i, j, trie.root, results, board);
        }
      }
    }

    return results;
  }

  public void searchWord(int x, int y, Node root, List<String> results, char[][] board) {
    if (root != null && root.isW && !results.contains(root.w)) {
      results.add(root.w);
      root.w = null;
      root.isW = false;
      return;
    }

    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length
            || root == null || !root.subs.containsKey(board[x][y])) {
      return;
    }

    char ch = board[x][y];
    for (int[] range: RANGE) {
      board[x][y] = '#';
      searchWord(x + range[0], y + range[1], root.subs.get(ch), results, board);
    }
    board[x][y] = ch;
    if (root.subs.get(board[x][y]).subs.isEmpty()) {
      root.subs.remove(board[x][y]);
    }
  }

  public class Node {
    String w;
    boolean isW;
    Map<Character, Node> subs;

    Node() {
      subs = new HashMap<>();
      isW = false;
    }
  }

  public class Trie {
    Node root;
    Trie() {
      this.root = new Node();
    }

    public void insert(String w) {
      Node curr = root;
      for (char ch: w.toCharArray()) {
        if (!curr.subs.containsKey(ch)) {
          Node node = new Node();
          curr.subs.put(ch, node);
        }
        curr = curr.subs.get(ch);
      }
      curr.isW = true;
      curr.w = w;
    }
  }

  public static void main(String[] args) {
    WordSearchIIRewrite sl = new WordSearchIIRewrite();

    char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
    //System.out.println(Arrays.deepToString(board));
    // NOTE:!!!!!The right way to print a two D array; for loop outter and print to string
    for (char[] b : board) {
      System.out.println(Arrays.toString(b));
    }
    String[] words = {"oath","pea","eat","rain"};
    System.out.println(sl.findWords(board, words));
  }
}
