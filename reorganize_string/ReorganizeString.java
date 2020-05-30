import java.util.*;

public class ReorganizeString {
    class CharCnt {
        public char ch;
        public int cnt;
        public CharCnt(char _ch, int _cnt) {
            ch = _ch;
            cnt = _cnt;
        }
    }
    public String reorganizeString(String s) {
        Map<Character, CharCnt> chrCntMap = new HashMap<>();
        for (char ch: s.toCharArray()) {
            if (chrCntMap.containsKey(ch)) {
                chrCntMap.put(ch, new CharCnt(ch, chrCntMap.get(ch).cnt + 1));
            } else {
                chrCntMap.put(ch, new CharCnt(ch, 1));
            }
        }

        PriorityQueue<CharCnt> chrIdxPq = new PriorityQueue<>(
                (a, b) -> (b.cnt - a.cnt));
        chrCntMap.forEach((k, v) -> chrIdxPq.add(v));

        StringBuilder result = new StringBuilder();
        while(!chrIdxPq.isEmpty()) {
            int i = 0;
            List<CharCnt> tempCharList = new ArrayList<>();
            while (i < 2) {
                if (!chrIdxPq.isEmpty()) {
                    CharCnt curr = chrIdxPq.poll();
                    curr.cnt--;
                    result.append(curr.ch);

                    if (curr.cnt >= 1) {
                        tempCharList.add(curr);
                    }
                } else if (tempCharList.size() !=0 ) {
                    return "";
                }
                i++;
            }
            chrIdxPq.addAll(tempCharList);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReorganizeString solution = new ReorganizeString();

        System.out.println("=====================");
        String input = "aab";
        System.out.println("s: " + input);
        System.out.println("result: " + solution.reorganizeString(input));

        System.out.println("=====================");
        String input1 = "aaab";
        System.out.println("s: " + input1);
        System.out.println("result: " + solution.reorganizeString(input1));

        System.out.println("=====================");
        String input2 = "vvvlo";
        System.out.println("s: " + input2);
        System.out.println("result: " + solution.reorganizeString(input2));
    }
}
