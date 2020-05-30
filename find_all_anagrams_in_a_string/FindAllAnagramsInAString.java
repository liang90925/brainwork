import java.util.*;

public class FindAllAnagramsInAString {
    // Use two maps to compare the content in the 
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) {
            return Collections.emptyList();
        }
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        // Build the pMap
        for (char ch: p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            // this will continue add.
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            // When i moves to equal to or bigger than pLen,
            // that means we have filled pLen of chars to sMap.
            // Therefore we need to remove one from the left and in the next round
            // new ones from the right will be add and old ones from the left will be removed
            if (i >= pLen) {
                int leftInx = i - pLen;
                char leftChar = s.charAt(leftInx);
                if (sMap.get(leftChar) == 1) {
                    sMap.remove(leftChar);
                } else {
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                }
            }

            if (sMap.equals(pMap)) {
                result.add(i - pLen + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString solution = new FindAllAnagramsInAString();
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