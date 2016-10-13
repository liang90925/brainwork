public class Solution {
  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> justifiedWords = new ArrayList<>();
    if (words == null || words.length == 0) {
      return justifiedWords;
    }

    int totalLth = 0;
    int wordsCnt = words.length;
    int lastIndx = 0;

    for (int i = 0; i <= wordsCnt; i++) {
      // the case when we need to put the previous word/words to a new string
      if (i == wordsCnt || totalLth + words[i].length() + i - lastIndx > maxWidth) {
        // the case for last line and line with only one word
        StringBuilder sb = new StringBuilder();
        int totlSpcs = maxWidth - totalLth;
        int wordsNum = i - lastIndx; // number of words needed to build the new string
        if (i == wordsCnt || wordsNum == 1) {
          buildString(words, sb, lastIndx, i, 1, 0);
          // 这个space计算是个非常容易错的点，单独给写出来了， 以后熟练了可以还原
          int extraSpc = maxWidth - sb.length();
          appendSpaces(sb, extraSpc);
        } else {
          int cmmnSpcs = totlSpcs / (wordsNum - 1);
          int extrSpcs = totlSpcs % (wordsNum - 1);
          buildString(words, sb, lastIndx, i, cmmnSpcs, extrSpcs);
        }
        justifiedWords.add(sb.toString());
        lastIndx = i;
        //!!!!!!!!!!!!!!!!!!!!!!!!!非常重要且容易忘记!!!!!!!!!!!!!!!!!!!!!!
        if (i != wordsCnt) {
          totalLth = words[i].length();
        }
      } else {
        totalLth += words[i].length();
      }
    }
    return justifiedWords;
  }

  private static void appendSpaces(StringBuilder sb, int spaceNums) {
    while (spaceNums-- > 0) {
      sb.append(" ");
    }
  }

  // put the duplicate regarding building the string with words and spaces to here.
  private static void buildString(String[] words, StringBuilder sb,
                                  int start, int end, int spaceNums, int extrSpcs) {
    while (start < end) {
      sb.append(words[start]);
      if (start != end - 1) {
        appendSpaces(sb, spaceNums);
        if (extrSpcs > 0) {
          appendSpaces(sb, 1);
          extrSpcs--;
        }
      }
      start++;
    }
  }

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }

    // 别忘了怎么initiate string array
    String[] words = {"this", "is",  "a",  "tst",  "for", "a", "very", "and", "verydifficult", "coding", "question", "text", "justic", "ation"};

    List<String> result = fullJustify(words, 14);
    System.out.println(result);
  }
}
