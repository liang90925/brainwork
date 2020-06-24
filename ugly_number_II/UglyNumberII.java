import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII {
    private final Long[] UGLY_NUM = new Long[]{2L, 3L, 5L};
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        if (n <= 1) {
            return n;
        }
        // write your code here
        HashSet<Long> usedNum = new HashSet<>();
        PriorityQueue<Long> uglyNums = new PriorityQueue<>();
        for (long uglyNum: UGLY_NUM) {
            uglyNums.offer(uglyNum);
            usedNum.add(uglyNum);
        }

        int i = 2;
        Long num = 2L;
        while (i <= n) {
            num = uglyNums.poll();
            for (long uglyNum: UGLY_NUM) {
                long newNum = num * uglyNum;
                if (!usedNum.contains(newNum)) {
                    usedNum.add(newNum);
                    uglyNums.offer(newNum);
                }
            }
            i++;
        }
        return num.intValue();
    }

    public static void main(String[] args) {
        UglyNumberII solution = new UglyNumberII();
        System.out.println(solution.nthUglyNumber(9) + " ===  10");
    }
}
