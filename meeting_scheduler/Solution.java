class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // Do not need to check inputs since there are the contrains already
        int s1c = 0;
        int s2c = 0;
        
        // sort two arrayrs;
        Comparator<int[]> comparator = (int[] entry1, int[] entry2) -> {
            if (entry1[0] > entry2[0]) {
               return 1;  
            } else {
               return -1;  
            }
        };
        
        Arrays.sort(slots1, comparator);
        Arrays.sort(slots2, comparator);
        
        while (s1c < slots1.length && s2c < slots2.length) {
            // if (!checkInnerInterval(slots1, s1c, duration) 
            //     || !checkInnerInterval(slots2, s2c, duration)) {
            //     return results;
            // }
            // Find the bigger value of the left side
            int left = Math.max(slots1[s1c][0], slots2[s2c][0]);
            // Find the smaller value of the left side
            int right = Math.min(slots1[s1c][1], slots2[s2c][1]);
            
            if ((right - left) >= duration) {
                return Arrays.asList(left, left + duration);
            } else {
                if (slots2[s2c][1] < slots1[s1c][1]) {
                    s2c++;
                } else {
                    s1c++;
                }
            }
        }
        return Arrays.asList();
    }
    
    // public boolean checkInnerInterval(int[][] slot, int index, int duration) {
    //     if ((slot[index][1] - slot[index][0]) < duration) {
    //         index++;
    //     }
    //     if (index == slot.length) {
    //         return false;
    //     } else {
    //         return true;
    //     }
    // }
}
