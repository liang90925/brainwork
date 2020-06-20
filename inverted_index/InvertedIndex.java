import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex {
    class Document {
        public int id;
        public String content;
    }

    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> results = new HashMap<>();

        for(Document document: docs) {
            int id = document.id;
            String content = document.content;
            String[] segments = content.split(" ");

            for (String segment: segments) {
                if (segment.length() == 0) {
                    continue;
                }
                List<Integer> indexes = results.getOrDefault(segment, new ArrayList<>());
                if (indexes.isEmpty() || indexes.get(indexes.size() - 1) != id) {
                    indexes.add(id);
                    results.put(segment, indexes);
                }
            }
        }
        return results;
    }

}
