import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class AlvinSolution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int i1 = 0;
        int i2 = 0

        preprocess(slots1);
        preprocess(slots2);
        while (i1 < slots1.length && i2 < slots2.length) {
            int[] slot1 = slots1[i1];
            int[] slot2 = slots2[i2];
 
            int[] overlap = overlap(slot1, slot2);
            if (overlap.length > 0 && overlap[1] - overlap[0] >= duration) {
                return Arrays.asList(overlap[0], overlap[0] + duration);
            }
            if (slot1[0] < slot2[0]) {
                i1++;
            } else {
                i2++;
            }
        }
        return new ArrayList<>();
    }
 
    private int[] overlap(int[] slot1, int[] slot2) {
        int start = Math.max(slot1[0], slot2[0]);
        int end = Math.min(slot1[1], slot2[1]);
        if (start <= end) {
            return new int[] {start, end};
        }
        return new int[] {};
    }
 
    private void preprocess(int[][] slots) {
        quickSort(slots, 0, slots.length - 1);
    }
 
    private void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
 
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
 
    private int partition (int[][] arr, int low, int high) {
        int pivot = arr[high][0];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j][0] < pivot) {
                i++;
                int[] tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int[] tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }
 
    /**
     *
     * Example 1:
     * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
     * Output: [60,68]
     *
     * Example 2:
     * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
     * Output: []
     */
    public static void main(String[] args) {
        System.out.println(new Solution().minAvailableDuration(
                new int[][]{{10,50},{60,120},{140,210}},
                new int[][]{{0,15},{60,70}},
                8));
 
        System.out.println(new Solution().minAvailableDuration(
                new int[][]{{140,210},{60,120},{10,50}},
                new int[][]{{0,15},{60,70}},
                8));
 
        System.out.println(new Solution().minAvailableDuration(
                new int[][]{{10,50},{60,120},{140,210}},
                new int[][]{{0,15},{60,70}},
                12));
    }
}
