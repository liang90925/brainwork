import com.sun.tools.jdi.SocketListeningConnector;

import java.util.*;

public class WordSearchRbIIPractice {
    public static class Node {
        String w;
        Map<Character, Node> children;
        boolean isWord;

        Node() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    public static class Trie {
        Node root;
        Trie () {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new Node());
                }
                curr = curr.children.get(ch);
            }
            curr.isWord = true;
            curr.w = word;
        }

        public boolean containPath(String path) {
            Node curr = root;
            for (int i = 0; i < path.length(); i++) {
                char ch = path.charAt(i);
                if (!curr.children.containsKey(ch)) {
                    return false;
                }
                curr = curr.children.get(ch);
            }
            return true;
        }

        public boolean searchWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!curr.children.containsKey(ch)) {
                    return false;
                }
                curr = curr.children.get(ch);
            }
            return curr.isWord;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        // NULL and empty checks

        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

        List<String> results = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.children.containsKey(board[i][j])) {
                    search(i, j, trie.root, board, results);
                }
            }
        }

        return results;
    }

    public void search(int x, int y, Node curr, char[][] board, List<String> results) {
        if (curr != null && curr.isWord && !results.contains(curr.w)) {
            results.add(curr.w);
        }

        if (isValid(x, y, board.length, board[0].length)
                && curr != null
                && curr.children.containsKey(board[x][y])
        ) {

            char ch = board[x][y];
            board[x][y] = '#';
            for (int[] range: RANGE) {
                search(x + range[0], y + range[1], curr.children.get(ch), board, results);
            }
            board[x][y] = ch;

        } else {
            return;
        }
    }

    private static final int[][] RANGE = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >=0 && y < col;
    }

    public static void main(String[] args) {
        WordSearchRbIIPractice solution = new WordSearchRbIIPractice();
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        //System.out.println(Arrays.deepToString(board));
        // NOTE:!!!!!The right way to print a two D array; for loop outter and print to string
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(solution.findWords(board, words)  + " ===  [\"eat\",\"oath\"]");

    }
}
