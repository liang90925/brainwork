import java.util.*;
import java.util.stream.Collectors;

public class MiniCassandraTreeMap {

    /**
     * Definition of Column:
     * public class Column {
     *     public int key;
     *     public String value;
     *     public Column(int key, String value) {
     *         this.key = key;
     *         this.value = value;
     *    }
     * }
     */

    public class Column {
        public int key;
        public String value;
        public Column(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

//    Map<String, List<Column>> store = new HashMap<>();
    Map<String, NavigableMap<Integer, String>> store = new HashMap<>();

    public MiniCassandraTreeMap() {
        // do intialization if necessary
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String row_key, int column_key, String value) {
        // write your code here
        if (!store.containsKey(row_key)) {
            store.put(row_key, new TreeMap<>());
        }
        store.get(row_key).put(column_key, value);
    }

    /*
     * @param row_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String row_key, int column_start, int column_end) {
        // write your code here
        if (!store.containsKey(row_key)) {
            return Collections.emptyList();
        }

        List<Column> result = new ArrayList<>();
        store.get(row_key)
                .subMap(column_start, true, column_end, true)
                .forEach((key, value) -> result.add(new Column(key, value)));
        return result;
   }
}
