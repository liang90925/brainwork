import java.util.LinkedList;

class MeetingSchedule {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    // Do not need to check inputs since there are the contrains already
    int s1c = 0;
    int s2c = 0;
    List<Integer> results = new ArrayList<>();

    // sort two arrayrs;
    sort2Darray(slots1);
    sort2Darray(slots2);

    while (s1c < slots1.length && s2c < slots2.length) {
      if (!checkInnerInterval(slots1, s1c, duration)
              || !checkInnerInterval(slots2, s2c, duration)) {
        LinkedList
        return results;
      }
      // Find the bigger value of the left side
      int left = Math.max(slots1[s1c][0], slots2[s2c][0]);
      // Find the smaller value of the left side
      int right = Math.min(slots1[s1c][1], slots2[s2c][1]);

      if ((right - left) >= duration) {
        results.add(left);
        results.add(left + duration);
        return results;
      } else {
        if (slots2[s2c][1] < slots1[s1c][1]) {
          s2c++;
        } else {
          s1c++;
        }
      }
    }
    return results;

  }
  public void sort2Darray(int[][] slot) {
    Arrays.sort(slot, new Comparator<int[]>() {

      @Override
      // Compare values according to columns
      public int compare(final int[] entry1, final int[] entry2) {
        if (entry1[0] > entry2[0]) {
          return 1;
        } else {
          return -1;
        }
      }
    });
  }

  public boolean checkInnerInterval(int[][] slot, int index, int duration) {
    if ((slot[index][1] - slot[index][0]) < duration) {
      index++;
    }
    if (index == slot.length) {
      return false;
    } else {
      return true;
    }
  }
}