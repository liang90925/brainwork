public class Solution {
  // first implement the TrieNode and Trie
  class TrieNode {
    char c;
    String word;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean hasWord;
    // this constructor is used for dummy root node
    public TrieNode() {

    }
    public TrieNode(char c) {
      this.c = c;
      this.word = "";
      this.hasWord = false;
    }
  }
  public class Trie {
    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    // insert word into Trie tree
    public void insert(String word) {
      TrieNode curr = root;
      Map<Character, TrieNode> children = curr.children;

      for (int i = 0; i < word.length(); i++) {
        char wCh = word.charAt(i);
        if (children.containsKey(wCh)) {
          curr = children.get(wCh);
        } else {
          TrieNode tNode = new TrieNode(wCh);
          children.put(wCh, tNode);
          curr = tNode;
        }
        children = curr.children;
      }
      curr.word = word;
      curr.hasWord = true;
    }

    public boolean searh(String word) {
      TrieNode curr = root;
      Map<Character, TrieNode> children = curr.children;

      for (int i = 0; i < word.length(); i++) {
        char wCh = word.charAt(i);
        if (children.containsKey(wCh)) {
          curr = children.get(wCh);
        } else {
          return false;
        }
      }
      return curr.hasWord;
    }
  }

  private int[] row = {1, -1, 0, 0};
  private int[] col = {0, 0, 1, -1};

  private void search(char[][] board, int i, int j, TrieNode node, List<String> result) {
    if (node.hasWord && !result.contains(node.word)) {
      result.add(node.word);
    }

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0' || node == null) {
      return;
    }

    // be careful of the following logic
    if (node.children.containsKey(board[i][j])) {
      for (int k = 0; k < 4; k++) {
        // have a char to record the current board char and set it to 0 to avoid duplicate
        char now =  board[i][j];
        board[i][j] = '0';
        // don't for get to use now and DONOTuse board[i][j]
        search(board, i + row[k], j + col[k], node.children.get(now), result);
        board[i][j] = now;
      }
    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();

    Trie trie = new Trie();

    for (String word: words) {
      trie.insert(word);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        search(board, i, j, trie.root, result);
      }
    }

    return result;
  }
}
