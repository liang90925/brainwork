import java.util.*;

public class WordSearchII {
  public static class Node {
    char c; // 可以省略
    String w;
    boolean isW;
    Map<Character, Node> children = new HashMap<>();

    public Node(){}
    public Node(char c) {
      this.c = c;
      this.w = "";
      this.isW = false;
    }
  }

  public static class Trie {
    private Node root;

    Trie() {
      root = new Node();
    }

    public void insert(String word) {
      Node curr = root;
      Map<Character, Node> children = curr.children;

      for (int i = 0; i < word.length(); i++) {
        char wordC = word.charAt(i);
        if (children.containsKey(wordC)) {
          curr = children.get(wordC);
        } else {
          Node newNode = new Node(wordC);
          children.put(wordC, newNode);
          curr = newNode;
        }
        children = curr.children;
      }
      curr.w = word;
      curr.isW = true;
    }

    // not used in this question
    public boolean search(String word) {
      Node curr = root;
      Map<Character, Node> children = curr.children;

      for (int i = 0; i < word.length(); i++) {
        char wordC = word.charAt(i);
        if (children.containsKey(wordC)) {
          curr = children.get(wordC);
        } else {
          return false;
        }
        children = curr.children;
      }
      return curr.isW;
    }

    public boolean startWith(String prefix) {
      Node curr = root;
      Map<Character, Node> children = curr.children;

      for (int i = 0; i < prefix.length(); i++) {
        char wordC = prefix.charAt(i);
        if (!children.containsKey(wordC)) {
          return false;
        }
        children = curr.children;
      }
      return true;

    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    if (board == null || board.length == 0 || board[0].length == 0 ||
            words.length == 0) {
      return result;
    }

    Trie t = new Trie();


    for (String word : words) {
      t.insert(word);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        search(board, i, j, t.root, result);
      }
    }
    return result;
  }

  private static final int[] ROW = {1, -1, 0, 0};
  private static final int[] COL = {0, 0, 1, -1};

  private void search(char[][] board, int i, int j, Node curr, List<String> result) {
    if (curr.isW && !result.contains(curr.w)) {
      result.add(curr.w);
    }

    if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            curr == null) {
      return;
    }

    char currCh = board[i][j];
    if (curr.children.containsKey(currCh)) {
      for (int k = 0; k < ROW.length; k++) {
        board[i][j] = '#';
        search(board, i + ROW[k], j + COL[k], curr.children.get(currCh), result);

      }
      board[i][j] = currCh;
    }
  }

  public static void main(String[] args) {
    WordSearchII sl = new WordSearchII();

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
