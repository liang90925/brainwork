import sun.plugin2.message.StopAppletMessage;

import java.util.Arrays;

public class StoneGame {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // write your code here
        // Using DP
        if (A == null || A.length <= 1) {
            return 0;
        }
        int len = A.length;

        int[] minPrevSum = new int[len];
        int[] minPrevScore = new int[len];
        minPrevScore[0] = 0;
        minPrevSum[0] = A[0];
        minPrevScore[1] = minPrevSum[1] = A[0] + A[1];
        for (int i = 2; i < len; i++) {
            int option1Sum = A[i] + minPrevSum[i -1];
            int option1Score = option1Sum + minPrevScore[i - 1];

            int option2Sum = A[i] + A[i -1] + minPrevSum[i -2];
            int option2Score = option2Sum + minPrevScore[i - 2] + A[i] + A[i -1]; // A[i] + A[i -1] is the additional score introduced because of the option

            if (option1Score < option2Score) {
                minPrevScore[i] = option1Score;
            } else {
                minPrevScore[i] = option2Score;
            }
            if (option1Sum < option2Sum) {
                minPrevSum[i] = option1Sum;
            } else {
                minPrevSum[i] = option2Sum;
            }
        }
        return minPrevScore[len - 1];
    }

    /**
     * @param A: An integer array
     * @return: An integer
     */
//    public int stoneGame(int[] A) {
//        // write your code here
//        // Using DP
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//        int len = A.length;
//        if (len <= 2) {
//            return Arrays.stream(A).sum();
//        }
//
////        int[] minPrevSum = new int[len];
////        minPrevSum[0] = A[0];
////        minPrevSum[1] = A[0] + A[1];
//        int[] minPrevScore = new int[len];
//        minPrevScore[0] = 0;
//        minPrevScore[1] = A[0] + A[1];
//        int sum =  A[0] + A[1];
//        for (int i = 2; i < len; i++) {
//            sum += A[i];
//            int option1Score = sum + minPrevScore[i - 1];
//            int option2Score = sum + minPrevScore[i - 2] + A[i] + A[i -1]; // A[i] + A[i -1] is the additional score introduced because of the option
//            minPrevScore[i] = Math.min(option1Score, option2Score);
//        }
//        return minPrevScore[len - 1];
//    }


    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        stoneGame.stoneGame(new int[]{1,10,11,12,15,16,19,4,5,9,7});
        System.out.println(stoneGame.stoneGame(new int[]{3, 4, 3}) + " ==== 17");
        System.out.println(stoneGame.stoneGame(new int[]{4, 1, 1, 4}) + " ==== 18");
        System.out.println(stoneGame.stoneGame(new int[]{1,10,11,12,15,16,19,4,5,9,7}) + " ==== 363");

    }
}
