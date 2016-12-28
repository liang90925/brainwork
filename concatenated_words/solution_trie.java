public class Solution {
  // build the TrieNode class
  class Node {
    private char ch;
    private Map<Character, Node> children;
    private boolean isWord;

    Node() {
      this.children = new HashMap<>();
      this.isWord = false;
    }
    Node(char ch) {
      this.ch = ch;
      this.children = new HashMap<>();
      this.isWord = false;
    }
  }

  // Build the Trie class with insert and search function
  public class Trie {
    private Node root;

    Trie() {
      root = new Node();
    }

    public void insert(String word) {
      Node curr = root;

      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        Map<Character, Node> children = curr.children;

        if (!children.containsKey(ch)) {
          Node newNode = new Node(ch);
          children.put(ch, newNode);
        }
        curr = children.get(ch);
      }
      curr.isWord = true;
    }

    public boolean search(String word) {
      Node curr = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        Map<Character, Node> children = curr.children;
        if (!children.containsKey(ch)) {
          return false;
        } else {
          curr = children.get(ch);
        }
      }
      return curr.isWord;
    }
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    if (words == null || words.length <= 2) {
      return Collections.emptyList();
    }

    List<String> result = new ArrayList<>();

    // First new a trie class
    Trie trie = new Trie();

    // Insert the input word array to trie;
    for (String word : words) {
      trie.insert(word);
    }

    // for each word, search to check if it was cancatinated by other words in the array
    for (String word : words) {
      if (search(word, trie, 0)) {
        result.add(word);
      }
    }

    return result;
  }

  private boolean search(String word, Trie trie, int start) {
    // Note! must get the root of the trie, so that you can get the childrens from the root
    Node node = trie.root;

    for (int i = start; i < word.length(); i++) {
      // get first char and check if the node's children contains the character
      // if not, return false;
      char ch = word.charAt(i);
      node = node.children.get(ch);
      if (node == null) {
        return false;
      }
      // when yes, get the suffix,
      // if the node currently can build a word, and the suffix can be found from trie
      // or can be searched using the same technic, that means the word was concatenated by other words from the input list
      if (i + 1 < word.length()) {
        String suffix = word.substring(i + 1);
        if (node.isWord && (trie.search(suffix) || search(word, trie, i + 1))) {
          return true;
        }
      }
    }
    return false;
  }
}
