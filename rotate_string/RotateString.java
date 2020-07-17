public class RotateString {
    public boolean rotateString(String A, String B) {
        int alen = A.length();
        int blen = B.length();
        if (alen != blen) {
            return false;
        }
        if (alen == 0) {
            return true;
        }
        for (int i = blen; i >= 1; i--) {
            int idx = A.indexOf(B.substring(0, i));
            if (idx != -1) {
                return verifyReverse(A.substring(0, idx), B.substring(i));
            }
        }
        return false;
    }

    private boolean verifyReverse(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        if (alen != blen) {
            return false;
        }
        return a.equals(b);
    }
}
