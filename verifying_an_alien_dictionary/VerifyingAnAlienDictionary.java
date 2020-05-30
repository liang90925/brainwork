public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {

        if (words.length <= 0) {
            return true;
        }

        // The orderArray stores the location+1 of each char seen in order
        int[] orderArray = new int[26];

        for(int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            orderArray[getCharIdx(ch)] = i+1;
        }

        for (int i = 1; i  < words.length; i++) {
            // Compare the current word with the previous word
            if (!compare(words[i - 1], words[i], orderArray)) {
                return false;
            }
        }
        return true;
    }

    public boolean compare(String word1, String word2, int[] orderArray) {
        int i = 0;
        int w1Len = word1.length();
        int w2Len = word2.length();

        while (i < w1Len && i < w2Len) {
            int w1ChIdx = getCharIdx(word1.charAt(i));
            int w2ChIdx = getCharIdx(word2.charAt(i));
            i++;
            if (orderArray[w1ChIdx] < orderArray[w2ChIdx]) {
                return true;
            }
            if (orderArray[w1ChIdx] > orderArray[w2ChIdx]) {
                return false;
            }
        }
        return w1Len <= w2Len;
    }

    public int getCharIdx(char ch) {
        return (int) ch - 97;
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary solution = new VerifyingAnAlienDictionary();

        System.out.println("===================");
        String[] words = new String[]{"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println("words: " + words);
        System.out.println("order: " + order);
        System.out.println(solution.isAlienSorted(words, order));

        System.out.println("===================");
        String[] words1 = new String[]{"word","world","row"};
        String order1 = "worldabcefghijkmnpqstuvxyz";
        System.out.println("words: " + words1);
        System.out.println("order: " + order1);
        System.out.println(solution.isAlienSorted(words1, order1));

        System.out.println("===================");
        String[] words2 = new String[]{"apple","app"};
        String order2 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("words: " + words2);
        System.out.println("order: " + order2);
        System.out.println(solution.isAlienSorted(words2, order2));
    }
}
