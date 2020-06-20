import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int count;
 *     public String content;
 * }
 *
 *class Pair {
 *   private String content;
 *   private int count;
 *
 *   Pair(String key, int value) {
 *       this.key = key;
 *       this.value = value;
 *   }
 *   public String getContent(){
 *	 	 return this.content;
 *	 }
 *	public int getCount(){
 *   	 return this.count;
 *   }
 *
 *}
 */

public class GoogleSuggestion {
    class Document {
        public int count;
        public String content;
    }

    class Pair {
        private String content;
        private int count;

        Pair(String key, int value) {
            this.content = key;
            this.count = value;
        }
        public String getContent(){
            return this.content;
        }
        public int getCount(){
            return this.count;
        }
    }

//    class OutputCollector<K, V> {
//        public void collect(K key, V value) {
//            // Adds a key/value pair to the output buffer
//        }

    public static class Map {
        public void map(Document value,
                        OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Pair value);
            Pair valuePair =  new Pair(value.content, value.count);
            for (int i = 1; i <= value.content.length(); i++) {
                output.collect(value.content.substring(0, i), valuePair);
            }
        }
    }

    public static class Reduce {
        private int top10 = 10;
        private PriorityQueue<Pair> pq;
        private Comparator<Pair> pairComparator = (o1, o2) -> {
            if (o1.getCount() != o2.getCount()) {
                return o1.getCount() - o2.getCount();
            }
            return o2.getContent().compareTo(o1.getContent());
        };

        public Reduce() {
            pq = new PriorityQueue<>(pairComparator);
        }

        public void setup() {
            // initialize your data structure here
        }
        public void reduce(String key, Iterator<Pair> values, OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Pair value);
            List<Pair> results = new ArrayList<>();
            while(values.hasNext()) {
                pq.offer(values.next());
                if (pq.size() > top10) {
                    pq.poll();
                }
            }
            while(!pq.isEmpty()) {
                results.add(pq.poll());
            }
            int n = results.size();
            for (int i = n - 1; i >= 0; i--) {
                output.collect(key, results.get(i));
            }
        }
    }
}
