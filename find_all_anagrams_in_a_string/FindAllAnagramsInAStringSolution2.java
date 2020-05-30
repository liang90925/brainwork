import java.util.*;

public class FindAllAnagramsInAStringSolution2 {
    // Use two maps to compare the content in the 
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();

        int[] tempCnts = new int[256];

        // Put the char and count to the tempCnts array
        for (char ch: p.toCharArray()) {
            tempCnts[ch]++;
        }

        int equalCount = 0;
        int left = 0;

        for (int i = 0; i < sLen; i++) {
            char sCh = s.charAt(i);
            if (tempCnts[sCh] > 0) {
                equalCount++;
            }
            tempCnts[sCh]--;

            // Because there will be cases that left stays at rare left and need to move to right
            // when the chars are not in p
            while (equalCount == pLen) {
                if ((i - left + 1) == pLen) {
                    result.add(left);
                }
                // move to one step to the right of the left.
                // therefore increase 1 to the tempCnts[left]
                tempCnts[s.charAt(left)]++;
                if (tempCnts[s.charAt(left)] > 0) {
                    // This means that the char at left is also in string p
                    // Therefore we need to find another one.
                    equalCount--;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAStringSolution2 solution = new FindAllAnagramsInAStringSolution2();
//
//        System.out.println("==========");
//        String s1 = "cbaebabacd";
//        String p1 = "abc";
//        System.out.println("s: " + s1);
//        System.out.println("p: " + p1);
//        System.out.println("result: " + solution.findAnagrams(s1, p1));
//
//        System.out.println("==========");
//        String s2 = "abab";
//        String p2 = "ab";
//        System.out.println("s: " + s2);
//        System.out.println("p: " + p2);
//        System.out.println("result: " + solution.findAnagrams(s2, p2));


        System.out.println("==========");
        String s3 = "abacbabc";
        String p3 = "abc";
        System.out.println("s: " + s3);
        System.out.println("p: " + p3);
        System.out.println("result: " + solution.findAnagrams(s3, p3));
    }

}



//    int i = 0, j = 0;
//    List<Integer> result = new ArrayList<>();
//    String newP = p;
//        while(i <= (s.length() - p.length())) {
//                while (j < i + p.length() && j <s.length()) {
//        char ch = s.charAt(j);
//        int chInxInNewP = newP.indexOf(ch);
//        int chInxInP = p.indexOf(ch);
//        if (chInxInNewP != -1) {
//        newP = newP.replaceFirst(Character.toString(ch), "");
//        j++;
//        } else {
//        if (chInxInP == -1) {
//        i = j + 1;
//        j = i;
//        newP = p;
//        break;
//        } else {
//        i++;
//        j++;
//        break;
//        }
//        }
//        }
//        if (newP.isEmpty()) {
//        result.add(i);
//        newP = Character.toString(s.charAt(i));
//        i++;
//        }
//        }
//        return result;