import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class InvertedIndex {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] words = value.content.split(" ");
            for (String word: words) {
                if (word.length() > 0) {
                    output.collect(word, value.id);
                }
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> indexes = new ArrayList<>();
            int previous = -1;
            while(values.hasNext()) {
                int idx = values.next();
                if (idx != previous) {
                    indexes.add(idx);
                }
                previous = idx;
            }
            output.collect(key, indexes);

        }
    }
}