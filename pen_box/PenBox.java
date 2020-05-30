import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PenBox {
    /**
     * @param boxes: number of pens for each box
     * @param target: the target number
     * @return: the minimum boxes
     */
    public int minimumBoxes(int[] boxes, int target) {
        // write your code here
        int minTotalLen = Integer.MAX_VALUE;
        List<int[]> subarrays = getSubArrays(boxes, target);
        for (int i = 0; i < subarrays.size(); i++) {
            int firstArrayLen =  subarrays.get(i)[1] - subarrays.get(i)[0] + 1;
            int nextStartIdx = subarrays.get(i)[1] + 1;
            int minNextArrayLen = Integer.MAX_VALUE;
            for (int j = i + 1; j < subarrays.size(); j++) {
                if (subarrays.get(j)[0] < nextStartIdx) {
                    continue;
                }
                minNextArrayLen = Math.min(minNextArrayLen, subarrays.get(j)[1] - subarrays.get(j)[0] + 1);
            }
            if (minNextArrayLen != Integer.MAX_VALUE) {
                minTotalLen = Math.min(minTotalLen, firstArrayLen + minNextArrayLen);
            }
        }

        return minTotalLen == Integer.MAX_VALUE ? -1 : minTotalLen;
    }

    private List<int[]> getSubArrays(int[] boxes, int target) {
        List<int[]> subArrays = new ArrayList();
        int i = 0, j = 0;
        int cnt = boxes[0];
        while (i < boxes.length && j < boxes.length) {
            if (cnt == target) {
                subArrays.add(new int[]{i, j});
                j++;
                if (j < boxes.length) {
                    cnt += boxes[j];
                }
                continue;
            }
            if (cnt < target) {
                j++;
                if (j < boxes.length) {
                    cnt += boxes[j];
                }
            } else {
                if (i == j) {
                    i++;
                    j++;
                    if (i < boxes.length) {
                        cnt = boxes[i];
                    }
                } else {
                    cnt -= boxes[i];
                    i++;
                    if (i >= boxes.length) {
                        break;
                    }
                }
            }
        }
        return subArrays;
    }

    public static void main(String[] args) {
        PenBox penBox = new PenBox();
        List<int[]> subarrays = penBox.getSubArrays(new int[]{1, 2, 2, 1, 1, 1}, 3);
        subarrays.forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println("================");
        int len = penBox.minimumBoxes(new int[]{1, 2, 2, 1, 1, 1}, 3);
        System.out.println(len);
    }
}
