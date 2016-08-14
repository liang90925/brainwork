public class Solution {
  public String addBinary(String a, String b) {
    if (a == null || b == null) { return null; }

    // switch a,b for length to make sure a got the higher length;
    if (a.length() < b.length()) {
      String temp = a;
      a = b;
      b = temp;
    }

    int bIndex = b.length() - 1;
    int aIndex = a.length() - 1;
    int carrier = 0;
    String result = "";

    // loop over b with the shorter length first
    while (bIndex >= 0) {
      int addition = Integer.valueOf(b.charAt(bIndex) - '0') +  Integer.valueOf(a.charAt(aIndex) - '0') + carrier;
      carrier = addition / 2;
      result = String.valueOf(addition % 2) + result;
      bIndex--;
      aIndex--;
    }

    while (aIndex >= 0) {
      int addition = Integer.valueOf(a.charAt(aIndex) - '0') + carrier;
      carrier = addition / 2;
      result = String.valueOf(addition % 2) + result;
      aIndex--;
    }

    if (carrier == 1) {
      result = "1" + result;
    }

    return result;
  }
}
