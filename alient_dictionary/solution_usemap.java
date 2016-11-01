import java.util.*;

public class Solution {
  // 可以尝试使用两个map来做
  // 一个map存 key= character, value= list of 下家characters
  // 一个map存 key= character, value = inDegree

  public String alienOrder(String[] words) {
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] words = {  "wrt", "wrf", "er", "ett", "rftt"};
    String result = solution.alienOrder(words);
    System.out.println(result);
  }
}
