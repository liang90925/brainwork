
class TrieNode {
  public Map<Character, TrieNode> children;
  public boolean isWord;
  TrieNode() {
    children = new HashMap();
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
      if (!curr.children.containsKey(c)) {
        curr.children.put(c, new TrieNode());
      }
      curr = curr.children.get(c);
    }
    curr.isWord = true;
  }

  private boolean find(String word, int index, TrieNode node) {

    if (index == word.length()) {
      return node.isWord;
    }

    char c = word.charAt(index);
    if (node.children.containsKey(c)) {
      return find(word, index + 1, node.children.get(c));
    } else if (c == '.'){
      for (Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
        if (find(word, index + 1, child.getValue())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }

  // Returns true if the word is in the data structure.
  // A word could contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return find(word, 0, root);
  }
}
