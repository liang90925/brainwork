/*a better solution*/
public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length < 1) {
      return null;
    }

    int i = 0, j = numbers.length - 1;
    while (i < j) {
      int temp = numbers[i] + numbers[j];
      if (temp < target) {
        i++;
      } else if (temp > target) {
        j--;
      } else {
        return new int[]{i, j};
      }
    }
    return null;
  }
}



public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length < 1) {
      return null;
    }

    int i = 0, j = 1;
    while (i < numbers.length && j < numbers.length) {
      if((numbers[i] + numbers[j]) == target) {
        return new int[]{i, j};
      }
      if((numbers[i] + numbers[j]) < target) {
        i++; j++;
      } else {
        return null;
      }
    }
    return null;
  }
}
