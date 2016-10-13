public class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return resutl;
    }
    int totalLth = 0;
    int wordsCount = words.length;
    int lastIndex = 0;

    for (int i = 0; i <= wordsCount; i++) {
      if (i == wordsCount || totalLth + words[i].length() + i - lastIndex > maxWidth) {
        StringBuffer sb = new StringBuffer();
        int spaceCount = maxWidth - totalLth;
        int spaceSlot = i - lastIndex - 1;
        if (i == wordsCount || spaceSlot == 0) {
          for (int j = lastIndex; j < i; j++) {
            sb.append(words[j]);
            if (j != i - 1) {
              appendSpaces(sb, 1);
            }
          }
          appendSpaces(sb, maxWidth - sb.length());
        } else {
          int averageSpaceCount = spaceCount / spaceSlot;
          int spareSpaceCount = spaceCount % spaceSlot;
          for (int j = lastIndex; j < i; j++) {
            sb.append(words[j]);
            if (j != i - 1) {
              appendSpaces(sb, averageSpaceCount + ((j - lastIndex) < spareSpaceCount ? 1 : 0));
            }
          }
        }
        result.add(sb.toString());
        lastIndex = i;
        //!!!!!!!!!!!底下的if非常容易被忘记 要注意!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (i != wordsCount) {
          totalLth = words[i].length();
        }
      } else {
        totalLth += words[i].length();
      }
    }
    return result;
  }
  private void appendSpaces(StringBuffer sb, int count) {
    while(count-- > 0) {
      sb.append(" ");
    }
  }
}
