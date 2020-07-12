import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicatedFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> contentMap = new HashMap<>();

        for (String path: paths) {
            String[] curr = path.split(" ");
            for (int i = 1; i < curr.length; i++) {
                String[] fileContent = curr[i].split(" \\(");

                String file = curr[0] + "/" + fileContent[0];
                String key = fileContent[1];
                if (!contentMap.containsKey(key)) {
                    contentMap.put(key, new ArrayList<>());
                }

                contentMap.get(key).add(file);

            }
        }

        return contentMap.values().stream()
                .filter(fileList -> fileList.size() > 1)
                .collect(Collectors.toList());

    }
}
