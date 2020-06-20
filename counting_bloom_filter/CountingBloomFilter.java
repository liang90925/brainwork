import java.util.ArrayList;
import java.util.List;

//class HashFunction {
//    public int cap, seed;
//
//    public HashFunction(int cap, int seed) {
//        this.cap = cap;
//        this.seed = seed;
//    }
//
//    public int hash(String value) {
//        int ret = 0;
//        int n = value.length();
//        for (int i = 0; i < n; ++i) {
//            ret += seed * ret + value.charAt(i);
//            ret %= cap;
//        }
//        return ret;
//    }
//}

public class CountingBloomFilter {
    private int[] bits;
    private int k;
    private List<HashFunction> hashFunctions = new ArrayList<>();

    /*
     * @param k: An integer
     */
    public CountingBloomFilter(int k) {
        // do intialization if necessary
        this.k = k;
        for (int i = 0; i < k; i++) {
            hashFunctions.add(new HashFunction(100000 + i, 2*i + 3));
        }
        bits = new int[100000 + k];
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int position = hashFunctions.get(i).hash(word);
            bits[position] += 1;
        }
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void remove(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int position = hashFunctions.get(i).hash(word);
            bits[position] -= 1;
        }
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int position = hashFunctions.get(i).hash(word);
            if (bits[position] == 0) {
                return false;
            }
        }
        return true;
    }
}
