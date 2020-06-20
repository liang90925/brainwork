import java.util.*;

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */

public class SortIntegers {
    static class Element {
        int row;
        int col;
        int val;

        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static class Map {
        public void map(int key, List<Integer> value,
                        OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            Collections.sort(value);
            output.collect("key", value);
        }
    }

    public static class Reduce {
        public void reduce(String key, List<List<Integer>> values,
                           OutputCollector<String, List<Integer>> output) {

            List<Integer> results = new ArrayList<Integer>();
            if (values.size() == 0) {
                output.collect(key, results);
                return;
            }

            Comparator elementComparator = new Comparator<Element>(){
                @Override
                public int compare(Element left, Element right) {
                    return left.val - right.val;
                }
            };
            PriorityQueue<Element> elementPq = new PriorityQueue<>(values.size(), elementComparator);
            // Put first element in each list to que
            for (int i = 0; i <values.size(); i++) {
                if (values.get(i).size() > 0) {
                    elementPq.offer(new Element(i, 0, values.get(i).get(0)));
                }
            }

            while(!elementPq.isEmpty()) {
                Element curr = elementPq.poll();
                results.add(curr.val);
                if (curr.col + 1 < values.get(curr.row).size()) {
                    curr.col += 1;
                    elementPq.offer(new Element(curr.row, curr.col, values.get(curr.row).get(curr.col)));
                }
            }
            output.collect(key, results);
        }
    }
}
