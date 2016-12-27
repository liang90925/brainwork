
public class RandomizedSet {

  Map<Integer, Integer> valueToIndex;
  List<Integer> valueList;
  Random random;
  public RandomizedSet() {
    valueToIndex = new HashMap<>();
    valueList = new ArrayList<>();
    random = new Random();
  }

  public boolean insert(int val) {
    if (valueToIndex.containsKey(val)) {
      return false;
    }
    valueToIndex.put(val, valueList.size());
    valueList.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!valueToIndex.containsKey(val)) {
      return false;
    }

    // 交换当前需要删除的元素和list的最后一个元素
    int index = valueToIndex.get(val);
    if (index != valueList.size() - 1) {
      int lastValue = valueList.get(valueList.size() - 1);

      valueToIndex.put(lastValue, index);
      valueList.set(index, lastValue);
    }
    valueToIndex.remove(val);
    valueList.remove(valueList.size() - 1);
    return true;
  }

  public int getRandom() {
    // remember the method to generate randome
    int randomIndex = random.nextInt(valueList.size());
    return valueList.get(randomIndex);
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
