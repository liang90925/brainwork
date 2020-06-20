import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKLargestNumbersII {
    private PriorityQueue<Integer> pq;
    private int capacity;

    /*
     * @param k: An integer
     */public TopKLargestNumbersII(int k) {
        // do intialization if necessary
        this.pq = new PriorityQueue<>();
        this.capacity = k;
    }
    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (pq.size() == capacity) {
            int min = pq.peek();
            if (num > min) {
                pq.poll();
                pq.add(num);
            }
        } else {
            pq.add(num);
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        return pq.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TopKLargestNumbersII solution = new TopKLargestNumbersII(3);
        solution.add(3);
        solution.add(10);
        System.out.println(solution.topk());
        solution.add(1000);
        solution.add(-99);
        System.out.println(solution.topk());
        solution.add(4);
        System.out.println(solution.topk());
        solution.add(100);
        System.out.println(solution.topk());

    }
}
