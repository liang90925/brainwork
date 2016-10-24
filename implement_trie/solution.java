class TrieNode {
  char c;
  Map<Character, TrieNode> children = new HashMap<>();
  boolean hasWord;
  public TrieNode() {
  }
  public TrieNode(char c) {
    this.c = c;
  }
}


public class Trie {
  private TrieNode root; // a dummy root node.

  public Trie() {
    root = new TrieNode();
  }

  // Insert a word into the trie.
  public void insert(String word) {
    TrieNode curr = root;
    Map<Character, TrieNode> currChildren = curr.children;

    for (int i = 0; i < word.length(); i++) {
      char wordCh = word.charAt(i);
      if (currChildren.containsKey(wordCh)) {
        curr = currChildren.get(wordCh);
      } else {
        TrieNode tNode = new TrieNode(wordCh);
        currChildren.put(wordCh, tNode);
        curr = tNode;
      }
      currChildren = curr.children;
      if (i == word.length() - 1) {
        curr.hasWord = true;
      }
    }
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    if (searchWordNodePos(word) == null) {
      return false;
    } else if (searchWordNodePos(word).hasWord) {
      return true;
    }
    return false;
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    if (searchWordNodePos(prefix) != null) {
      return true;
    }
    return false;
  }

  private TrieNode searchWordNodePos(String s) {
    Map<Character, TrieNode> children = root.children;
    TrieNode curr = null;

    for (int i = 0; i < s.length(); i++) {
      char sCh = s.charAt(i);
      if (children.containsKey(sCh)) {
        curr = children.get(sCh);
        children = curr.children;
      } else {
        return null;
      }
    }
    return curr;
  }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("something");
// trie.search("key");
