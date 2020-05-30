import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PenBoxDP {
    /**
     * @param boxes: number of pens for each box
     * @param target: the target number
     * @return: the minimum boxes
     */
    public int minimumBoxes(int[] boxes, int target) {
        // write your code here
        int[] mins = new int[boxes.length + 1];
        Arrays.fill(mins, Integer.MAX_VALUE / 2);

        formMinsArrayFromEnd(boxes, mins, target);
        return getMinSumFromStart(boxes, mins, target);
    }

    private void formMinsArrayFromEnd(int[] boxes, int[] mins, int target) {
        // start from the end, fill the mins array
        // minsLen = boxesLen + 1;
        // minsLen[boxesLen] = Integer.MAX_VALUE;
        int boxesLen = boxes.length;
        int left = boxesLen - 1;
        int right = boxesLen - 1;
        int total = 0;

        while (left >= 0) {
            total += boxes[left];
            while (left < right && (total > target || boxes[right] == 0)) {
                total -= boxes[right];
                right--;
            }
            if (total == target) {
                mins[left] = right - left + 1;
            }
            mins[left] = Math.min(mins[left], mins[left + 1]);
            left--;
        }
    }

    private int getMinSumFromStart(int[] boxes, int[] mins, int target) {
        int boxesLen = boxes.length;
        int left = 0;
        int right = 0;
        int total = 0;
        int sum = Integer.MAX_VALUE;

        while (right < boxesLen) {
            total += boxes[right];
            while (left < right && (total > target || boxes[left] == 0)) {
                total -= boxes[left];
                left++;
            }
            if (total == target) {
                sum = Math.min(right - left + 1 + mins[right + 1], sum);
            }
            right++;
        }
        return sum >= Integer.MAX_VALUE / 2 ? -1 : sum;
    }

    public static void main(String[] args) {
        PenBoxDP penBox = new PenBoxDP();

        System.out.println("================");
        int len = penBox.minimumBoxes(new int[]{1, 2, 2, 1, 1, 1}, 3);
        System.out.println(len);
    }
}
