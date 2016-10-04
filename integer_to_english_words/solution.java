public class Solution {
  public String numberToWords(int num) {
    String[] units = {"", " Thousand", " Million", " Billion"};
    String result = "";
    int i = 0;
    while(num > 0) {
      int hundred = num % 1000;
      if (hundred > 0) {
        result = convertHundred(hundred) + units[i] +  (result == "" ? "" : " ") + result;
      }
      i++;
      num /= 1000;
    }
    return result == "" ? "Zero" : result;
  }

  public String convertHundred(int num) {
    String[] lessThanTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tenThWords = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    int a = num / 100, b = num % 100, c = num % 10;

    String result = b < 20 ?
                      lessThanTwenty[b] :
                      tenThWords[b/10]
                        + (c > 0 ? " " : "")
                        + lessThanTwenty[c];

    if (a > 0) {
      result = lessThanTwenty[a] + " Hundred" + (b > 0 ? " " : "") + result;
    }
    return result;
  }
}
