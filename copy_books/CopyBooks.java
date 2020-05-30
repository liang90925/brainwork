import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Arrays;

public class CopyBooks {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }

        // Get the sum of the pages
        int numPages = Arrays.stream(pages).sum();
        int max = Arrays.stream(pages).max().getAsInt();
        if ( k >= pages.length) {
            return max;
        }

        // Using Binary Search to find the min of the max pages;
        return BSMinMaxPages(pages, k, numPages);

    }
    public int BSMinMaxPages(int[] pages, int k, int numPages) {
        int left = 1;
        int right = numPages;

        while (left < right - 1) {
            // current MinMax
            int mid = ( left + right ) / 2;
            // Note that when you get the number that is equal to k, you can't make sure that this it the target numer
            // You still need to continue until narrow down to two numbers;
            if (getMinCopiers(pages, mid) <= k) {
                right = mid;
            } else {
                left = mid;
            }

        }
        return getMinCopiers(pages, left) <= k ? left : right;
    }

    public int getMinCopiers(int[] pages, int maxPages) {
        int copiers = 0;
        int sum = 0;
        for (int page : pages) {
            sum += page;
            if (sum >= maxPages) {
                copiers += 1;
                if (sum == maxPages) {
                    sum = 0;
                } else {
                    sum = page;
                }
            }
        }
        return sum > maxPages ? copiers + 2 : (sum > 0 ? copiers + 1: copiers);
    }

    public static void main(String[] args) {
        CopyBooks copyBooks = new CopyBooks();
        System.out.println(copyBooks.copyBooks(new int[]{3, 2, 4}, 3) + " ==== 4");
        System.out.println(copyBooks.copyBooks(new int[]{3, 2, 4}, 2) + " ==== 5");
        System.out.println(copyBooks.getMinCopiers(new int[]{3, 2, 4}, 3));
        System.out.println(copyBooks.copyBooks(new int[]{3, 2}, 6) + " ==== 3");
        System.out.println(copyBooks.copyBooks(new int[]{1}, 1)  + " ==== 1");
        System.out.println(copyBooks.copyBooks(new int[]{3}, 2) + " ==== 3");
        System.out.println(copyBooks.copyBooks(new int[]{3, 2, 1, 4, 2, 3, 5}, 3)  + " ==== 8");
        System.out.println(copyBooks.copyBooks(new int[]{3, 2, 1, 4, 2, 3, 5}, 4)  + " ==== 5");
        copyBooks.copyBooks(new int[]{3, 2, 1, 4, 2, 3, 5}, 5);
        System.out.println(copyBooks.copyBooks(new int[]{3, 2, 1, 4, 2, 3, 5}, 5)  + " ==== 5");
        System.out.println(copyBooks.copyBooks(new int[]{3, 2, 1, 4, 2, 3, 5}, 6)  + " ==== 5");
        System.out.println(copyBooks.copyBooks(new int[]{1,9,7,3,4,7}, 3) + " ==== 11");
    }
}
