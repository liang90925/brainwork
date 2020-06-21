import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArraysWithOutList {
    class Item {
        int row;
        int col;
        int val;

        public Item(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        int k = arrays.length;
        if (k == 0) {
            return new int[]{};
        }

        PriorityQueue<Item> pq = new PriorityQueue<Item>(k, Comparator.comparingInt(a -> a.val));
        int totalSize = 0;
        for (int i = 0; i < k; i++) {
            if (arrays[i].length != 0) {
                pq.offer(new Item(i, 0, arrays[i][0]));
            }
            totalSize += arrays[i].length;
        }

        int[] result = new int[totalSize];
        int index = 0;
        while(!pq.isEmpty()) {
            Item item = pq.poll();
            result[index++] = item.val;
            if (item.col < arrays[item.row].length - 1) {
                pq.offer(new Item(item.row, item.col + 1, arrays[item.row][item.col + 1]));
            }
        }

        return result;
    }
}
