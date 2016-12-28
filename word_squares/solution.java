
public class Solution {
  // build trie node and trie
  class TrieNode {
    List<String> wordsStartWith;
    TrieNode[] children;

    TrieNode() {
      this.wordsStartWith = new ArrayList<>();
      this.children = new TrieNode[26];
    }
  }

  public class Trie {
    private TrieNode root;

    Trie(String[] words) {
      root = new TrieNode();
      for (String word : words) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
          int index = ch - 'a';
          if (curr.children[index] == null) {
            curr.children[index] = new TrieNode();
          }
          curr.children[index].wordsStartWith.add(word);
          curr = curr.children[index];
        }
      }
    }

    public List<String> findByPrefix(String prefix) {
      List<String> words = new ArrayList<>();
      TrieNode curr = root;
      for (char ch : prefix.toCharArray()) {
        int index = ch - 'a';
        if (curr.children[index] == null) {
          return words;
        }
        curr = curr.children[index];
      }
      words.addAll(curr.wordsStartWith);
      return words;
    }
  }

  public List<List<String>> wordSquares(String[] words) {
    List<List<String>> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }

    Trie trie = new Trie(words);

    List<String> square = new ArrayList<>();
    int wordLen = words[0].length();

    for (String word : words) {
      square.add(word);
      helper(trie, square, result, wordLen);
      square.remove(square.size() - 1);
    }

    return result;
  }

  private void helper(Trie trie, List<String> square, List<List<String>> result, int wordLen) {
    if (square.size() == wordLen) {
      result.add(new ArrayList<>(square));
      return;
    }

    int index = square.size();
    StringBuilder prefixBuilder = new StringBuilder();
    for (String s : square) {
      prefixBuilder.append(s.charAt(index));
    }

    List<String> startWith = trie.findByPrefix(prefixBuilder.toString());
    
    for (String potentialWord : startWith) {
      square.add(potentialWord);
      helper(trie, square, result, wordLen);
      square.remove(square.size() - 1);
    }
  }
}
