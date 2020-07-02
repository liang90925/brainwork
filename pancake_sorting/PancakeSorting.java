import com.sun.tools.javac.code.Attribute;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        if (A == null || A.length <= 1) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();

        int len = A.length;

        Integer[] sortedIndex = new Integer[len];
        for (int i = 0; i < len; i++) {
            sortedIndex[i] =  i + 1;
        }
        Arrays.sort(sortedIndex, (a, b) -> A[b - 1] - A[a - 1]);

        for (int index: sortedIndex) {
            for (int num : result) {
                if (index <= num) {
                    index = num - index + 1;
                }
            }
            if (index != 1) {
                result.add(index);
            }
            if (len > 1) {
                result.add(len);
            }
            len--;
        }
        return result;
    }

    public static void main(String[] args) {
        PancakeSorting solution = new PancakeSorting();
        System.out.println(solution.pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
