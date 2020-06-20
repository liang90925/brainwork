public class ModernLudoI {
    /**
     * @param length: the length of board
     * @param connections: the connections of the positions
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        int[] counts = new int[length + 1];
        int[] fasterConns = new int[length + 1];

        for (int i = 0; i <= length; i++) {
            fasterConns[i] = i;
            counts[i] = Integer.MAX_VALUE;
        }

        // Check the connections array to any faster moves
        for (int[] pair : connections) {
            fasterConns[pair[0]] = pair[1];
        }
        counts[0] = 0;
        counts[1] = 0;

        for (int i = 2; i <= length; i++) {
            if (i <= 7) {
                counts[i] = 1;
            } else {
                int dice = 1;
                while(dice <= 6) {
                    int k = i - dice++;
                    counts[i] = Math.min(counts[k] + 1, counts[i]);
                }
            }
            counts[fasterConns[i]] = Math.min(counts[fasterConns[i]], counts[i]);
        }

        return counts[length];
    }

    public static void main(String[] args) {
        ModernLudoI solution = new ModernLudoI();
        System.out.println(solution.modernLudo(15, new int[][]{}));
    }
}
