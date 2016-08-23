public class Solution {
  public String simplifyPath(String path) {
    String result = "/";
    String[] stubs = path.split("/+");
    ArrayList<String> paths =  new ArrayList<>();

    for (String s : stubs) {
      if (s.equals("..")) {
        if (path.size() > 0) {
          paths.remove(path.size() - 1);
        }
      } else if (!s.equals(".") && !s.equals("")) {
        paths.add(s);
      }
    }

    for (String path : paths) {
      result += s + "/";
    }

    if (result.length() > 1) {
      result = result.substring(0, result.length() - 1);
    }

    return result;
  }
}
