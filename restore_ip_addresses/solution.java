
public class Solution {
  public List<String> restoreIpAddresses(String s) {
    if (s == null || s.length() < 3 || s.length() > 12) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<>();
    List<String> ipAddr = new ArrayList<>();
    helper(s, 0, ipAddr, result);
    return result;
  }

  private void helper(String s, int index, List<String> ipAddr, List<String> result) {
    if (ipAddr.size() == 4) {
      if (index == s.length()) {
        StringBuilder sb = new StringBuilder();
        for (String str : ipAddr) {
          sb.append(str).append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        result.add(sb.toString());
      }
      return;
    }

    // NOTE: NEED TO HAVE I <=3 && (index + i) <= s.length() or will have index outof boundary issue
    for (int i = 1; i <= 3 && (index + i) <= s.length(); i++) {
      String subStr = s.substring(index, index + i);
      // NOTE: The ip address should <256, and can not have 0 at the beginning unless it's just 0;
      // The if condition can also be put in a seperate validation function.
      if (subStr.length() == 1 ||
         (subStr.charAt(0) != '0' && Integer.valueOf(subStr) < 256 )) {
        ipAddr.add(subStr);
        helper(s, index + i, str, result);
        ipAddr.remove(ipAddr.size() - 1);
      }
    }
  }
}
