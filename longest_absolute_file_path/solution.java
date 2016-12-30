public class Solution {
  public int lengthLongestPath(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }
    // split the input by \n and check each part
    String[] parts = input.split("\n");
    // initiate the array with parts.length + 1 length, so that we don't have to check when index = 0;
    // index starts with 1
    int[] paths = new int[parts.length + 1];
    int maxLen = 0;
    for (String part : parts) {

      // NOTE: for lastIndexOf of ("\t"), since \t is one element, so exmaple : "\t\taaa", will return 1, instread of 2
      int arrayIndex = part.lastIndexOf("\t") + 1;

      // when we reach the file, update the maxLen and don't need to assign value to arrayIndex + 1
      if (part.contains(".")) {
        maxLen = Math.max(maxLen, paths[arrayIndex] + part.substring(arrayIndex).length());
      } else {
        // when we are still in the dir, add the length to previous path and add it to arrayIndex + 1
        paths[arrayIndex + 1] = paths[arrayIndex] + part.substring(arrayIndex).length() + 1;
      }
    }
    return maxLen;
  }
}
