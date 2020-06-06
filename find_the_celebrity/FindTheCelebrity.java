//public class FindTheCelebrity {
//}
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheCelebrity extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        int celebrity = 0;
        Set<Integer> notCelebrity = new HashSet<>();
        for (int i = 1; i < n; i++) {
            // when ppl knows i, that means i has the potential to be the celebrity
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (celebrity != i && knows(celebrity, i)) {
                return -1;
            }
            if (celebrity != i && !knows(i, celebrity)) {
                return -1;
            }
        }

        return celebrity;
    }
}