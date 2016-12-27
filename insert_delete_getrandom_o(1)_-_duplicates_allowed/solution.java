public class RandomizedCollection {

  Map<Integer, Set<Integer>> valueToIndexSet;
  List<Integer> valueList;
  Random random;

  /** Initialize your data structure here. */
  public RandomizedCollection() {
    valueToIndexSet = new HashMap<>();
    valueList = new ArrayList<>();
    random = new Random();
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    // when insert;
    // if map containskey, add the new index to the set;
    // or, create a set with the new index and add the val and indexSet pair to map
    // at end add the val to value list and return true if the val is first inserted.
    Set<Integer> set = valueToIndexSet.getOrDefault(val, new HashSet<>());

    set.add(valueList.size());
    valueToIndexSet.put(val, set);

    valueList.add(val);
    return set.size() == 1;
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    if (!valueToIndexSet.containsKey(val)) {
      return false;
    }

    // map containsKey
    // first get the index set belongs to the val
    Set<Integer> targetSet = valueToIndexSet.get(val);
    int targetSetFirstIndex = targetSet.iterator().next();
    // remove the first index from the target's indexSet
    targetSet.remove(targetSetFirstIndex);
    // remove the val to set pair if the set is empty
    // or update the val and set pair in the map
    if (targetSet.size() == 0) {
      valueToIndexSet.remove(val);
    }

    int lastIndexVal = valueList.get(valueList.size() - 1);

    // NOTE!!!: Only when the targetSetFirstIndex is not the lastIndex of the valueList, we do the switch;
    if (targetSetFirstIndex < valueList.size() - 1) {
      Set<Integer> lastIndexSet = valueToIndexSet.get(lastIndexVal);

      // remove the last index of the lastIndexSet
      // and add the targetSetFirstIndex to lastIndexSet
      lastIndexSet.remove(valueList.size() - 1);
      lastIndexSet.add(targetSetFirstIndex);

      // update the targetSetFirstIndex with the lastindexval
      valueList.set(targetSetFirstIndex, lastIndexVal);

    }

    // remove the last emelment from value map
    valueList.remove(valueList.size() - 1);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return valueList.get(random.nextInt(valueList.size()));
  }
}



/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
