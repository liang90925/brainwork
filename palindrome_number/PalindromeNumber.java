public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int y = 0;
        int temp = x;

        // Revert half of the number and compare
        while (temp > y) {
            y = y*10 +temp%10;
            temp /= 10;
        }


        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return y == temp || y/10 == temp;
    }
}



/*
// Another simple way is to revert the whole integer and compare
 public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int y = 0;
        int temp = x;

        while (temp != 0) {
            y = y*10 +temp%10;
            temp /= 10;
        }

        return y == x;
    }
 */