public class TwoSum {
  private Map<Integer, Integer> map;

  public TwoSum() {
    map = new HashMap<>();
  }

  public void add (int number) {
    if (map.containsKey(number)) {
      map.put(number, map.get(number) + 1);
    } else {
      map.put(number, 1);
    }
  }

  public boolean find(int value) {
    for (int key:map.keySet()) {
      int target = value - key;
      if (map.containsKey(target)) {
         if (target == key && map.get(target) < 2 ) {
           continue;
         } else {
           return true;
         }
      }
    }
  }
}
