import java.util.*;

public class CommonCrs {

    public Map<List<String>, List<String>> testCoding(List<List<String>> nameToCourse) {
        Map<List<String>, List<String>> result = new HashMap<>();

        for (int i = 0; i < nameToCourse.size(); i++) {
            List<String> comp1 = nameToCourse.get(i);

            for (int j = i + 1; j < nameToCourse.size(); j++) {
                List<String> comp2 = nameToCourse.get(j);
                Set<String> comp2Set = new HashSet<>();
                for (int k = 1; k < comp2.size(); k++) {
                    comp2Set.add(comp2.get(k));
                }

                List<String> names = new ArrayList<>();
                names.add(comp1.get(0));
                names.add(comp2.get(0));
                result.put(names, new ArrayList<>());

                for (String crs: comp1) {
                    if (comp2Set.contains(crs)) {
                        result.get(names).add(crs);
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] argv) {

        List<List<String>> nameToCourse = new ArrayList<>();
        List<String> user1 = new ArrayList<>(Arrays.asList("a", "math", "physics"));
        List<String> user2 = new ArrayList<>(Arrays.asList("b", "math", "chemistry", "english"));
        List<String> user3 = new ArrayList<>(Arrays.asList("c", "chemistry", "physics"));
        List<String> user4 = new ArrayList<>(Arrays.asList("d", "chemistry", "english"));
        nameToCourse.add(user1);
        nameToCourse.add(user2);
        nameToCourse.add(user3);
        nameToCourse.add(user4);

        CommonCrs solution = new CommonCrs();
        Map<List<String>, List<String>> result = solution.testCoding(nameToCourse);
        result.forEach(
                (key, value) -> {
                    System.out.println("key: " + key + ", value: " + value);
                });

        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");
    }
}

// Your previous work is preserved below:
//
// public