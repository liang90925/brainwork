import java.util.Arrays;

public class WoodCut {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int left = 0;
        int right = Arrays.stream(L).max().getAsInt();

        return binarySearchWoodCut(left, right, L, k);
    }

    public int binarySearchWoodCut(int left, int right, int[] woods, int kPieces) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;

            if (getMostCutNum(woods, mid) >= kPieces) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int getMostCutNum(int[] woods, int cutLength) {
        if (cutLength == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < woods.length; i++) {
            sum += woods[i]/cutLength;
        }
        return sum;
    }

    public static void main(String[] args) {
        WoodCut woodCut = new WoodCut();
        woodCut.woodCut(new int[]{232, 124, 456}, 7);
        System.out.println(woodCut.woodCut(new int[]{232, 124, 456}, 7) + " === 114");
        System.out.println(woodCut.woodCut(new int[]{1, 2, 3}, 7) + " === 0");
        System.out.println(woodCut.woodCut(new int[]{15}, 0) + " === 0");
    }
}
