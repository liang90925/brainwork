import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieV2 {
    public class Node {
        char c;
        Map<Character, Node> children;
        boolean hasWord;

        public Node(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.hasWord = false;
        }

        public Node() {
        }
    }

    Node root;

    public TrieV2() {
        // do intialization if necessary
        this.root =  new Node();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        Node curr = root;
        Map<Character, Node> children = curr.children;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!children.containsKey(ch)) {
                children.put(ch, new Node(ch));
            }

            Node nextNode = children.get(ch);
            children = nextNode.children;
            if (i == word.length() - 1) {
                nextNode.hasWord = true;
            }
        }
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        Node node = findWord(word);
        return node != null && node.hasWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        return findWord(prefix) != null;
    }

    private Node findWord(String word) {
        if (word.length() <= 0) {
            return null;
        }
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            } else {
                return null;
            }
        }
        return curr;
    }
}
