public class Solution {
  public String getHint(String secret, String guess) {
    int[] m = new int[256];
    int bulls = 0, cows = 0;

    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bulls++;
      } else {
        if (m[Integer.valueOf(secret.charAt(i))]++ < 0) {
          cows++;
        }
        if (m[Integer.valueOf(guess.charAt(i))]-- > 0) {
          cows++;
        }
      }
    }
    return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
  }
}
