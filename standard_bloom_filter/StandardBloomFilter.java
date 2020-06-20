import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class StandardBloomFilter {
    private BitSet bits;
    private int k;
    private List<HashFunction> hashFunctions;
    /*
     * @param k: An integer
     */
    public StandardBloomFilter(int k) {
        // do intialization if necessary
        this.k = k;
        hashFunctions = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            hashFunctions.add(new HashFunction(100000 + i, 2 * i + 3));
        }
        bits = new BitSet(100000 + k);

    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int position = hashFunctions.get(i).hash(word);
            bits.set(position);
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
            if (!bits.get(position)) {
                return false;
            }
        }
        return true;
    }
}
