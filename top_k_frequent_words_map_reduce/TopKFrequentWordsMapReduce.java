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
public class TopKFrequentWords {

    public static class Map {
        public void map(String key, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] words = value.content.split("\\ ");
            for (String word: words) {
                // NOTE: this is useful, so that "" won't be counted
                if (word.length() > 0) {
                    output.collect(word, 1);
                }

            }
        }
    }

    public static class WordCnt {
        String word;
        int cnt;
        public WordCnt(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    public static class Reduce {
        private int k;
        PriorityQueue<WordCnt> cntsPq;

        public void setup(int k) {
            // initialize your data structure here
            this.k = k;
            Comparator<WordCnt> comparator = new Comparator<WordCnt>(){
                public int compare(WordCnt a, WordCnt b) {
                    if (a.cnt == b.cnt) {
                        return b.word.compareTo(a.word);
                    }
                    return a.cnt - b.cnt;
                }
            };
            this.cntsPq = new PriorityQueue<WordCnt>(comparator);
        }

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while(values.hasNext()) {
                sum += values.next();
            }
            cntsPq.offer(new WordCnt(key, sum));
            if (cntsPq.size() > k) {
                cntsPq.poll();
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<WordCnt> results = new ArrayList<>();
            while(!cntsPq.isEmpty()) {
                results.add(cntsPq.poll());
            }
            int n = results.size();
            for (int i = n - 1; i >= 0; i--) {
                output.collect(results.get(i).word, results.get(i).cnt);
            }
        }
    }
}