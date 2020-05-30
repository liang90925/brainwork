import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Arrays;

public class CopyBooksII {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooksII(int[] times, int n) {
        // write your code here
        if (times == null || times.length == 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }

        // Get the sum of the pages
        int totalTime = times[0] * n;

        // Using Binary Search to find the min of the max times;
        return BSMinMaxTimes(times, n, totalTime);

    }
    public int BSMinMaxTimes(int[] times, int targetBooks, int maxTime) {
        int left = 1;
        int right = maxTime;

        while (left < right - 1) {
            // current MinMax
            int mid = ( left + right ) / 2;
            // Note that when you get the number that is equal to k, you can't make sure that this it the target numer
            // You still need to continue until narrow down to two numbers;
            if (getBooksCopied(times, mid) >= targetBooks) {
                right = mid;
            } else {
                left = mid;
            }

        }
        return getBooksCopied(times, left) >= targetBooks ? left : right;
    }

    public int getBooksCopied(int[] times, int maxTime) {
        int books = 0;
        for (int time : times) {
            books += maxTime/time;
        }
        return books;
    }

    public static void main(String[] args) {
        CopyBooksII copyBooks = new CopyBooksII();
        System.out.println(copyBooks.copyBooksII(new int[]{3, 2, 4}, 4) + " ==== 4");
        System.out.println(copyBooks.copyBooksII(new int[]{3, 2, 4, 5}, 4) + " ==== 4");
        System.out.println(copyBooks.copyBooksII(new int[]{3, 2}, 3) + " ==== 4");
        System.out.println(copyBooks.copyBooksII(new int[]{3, 2}, 4)  + " ==== 6");
        System.out.println(copyBooks.copyBooksII(new int[]{3}, 2) + " ==== 6");
        System.out.println(copyBooks.copyBooksII(new int[]{3, 2, 1, 4}, 9)  + " ==== 5");
        System.out.println(copyBooks.copyBooksII(new int[]{3, 2, 1, 4, 7}, 11)  + " ==== 6");
    }
}
