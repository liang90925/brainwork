
class TrieNode {
  public TrieNode[] children;
  public boolean isWord;
  TrieNode() {
    children = new TrieNode[26];
    for (int i = 0; i < 26; i++) {
      children[i] = null;
    }
    isWord = false;
  }
}

public class WordDictionary {
  private TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  // Adds a word into the data structure.
  public void addWord(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new TrieNode();
      }
      curr = curr.children[c - 'a'];
    }
    curr.isWord = true;
  }

  private boolean find(String word, int index, TrieNode node) {
    if (word.length() == index) {
      return node.isWord;
    }

    char c = word.charAt(index);
    if (c == '.') {
      for (int i = 0; i < 26; i++) {
        if (node.children[i] != null) {
          if (find(word, index + 1, node.children[i])) {
            return true;
          }
        }
      }
      return false;
    } else if (node.children[c - 'a'] != null) {
      return find(word, index + 1, node.children[c - 'a']);
    }
    return false;
  }

  // Returns true if the word is in the data structure.
  // A word could contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return find(word, 0, root);
  }
}
