import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
       StringBuilder stringBuilder = new StringBuilder();
        for (String s: strs) {
            stringBuilder.append(intToString(s.length()));
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();

        int size = s.length();
        int i = 0;

        while(i < size) {
            int strLen = stringToInt(s.substring(i, i + 4));
            i += 4;
            decodedStrings.add(s.substring(i, i + strLen));
            i += strLen;
        }
        return decodedStrings;
    }

    private String intToString (int len) {
        char[] lenInChars = new char[4];
        for (int i = 3; i >= 0; i--) {
            lenInChars[3 - i] = (char) (len >> (i * 8) & 0xff);
        }
        return new String(lenInChars);
    }

    private int stringToInt (String str) {
        int result = 0;

        for (char ch: str.toCharArray()) {
            result = (result << 8) + (int) ch;
        }
        return result;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings solution = new EncodeAndDecodeStrings();
        List<String> input = new ArrayList<>(Arrays.asList("hello", "world"));
        String encoded = solution.encode(input);
        System.out.println("Encode " + encoded);
        List<String> decoded = solution.decode(encoded);
        System.out.println("Decoded " + decoded);

        System.out.println("==========================");
        List<String> input2 = new ArrayList<>(Arrays.asList("63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "));
        String encoded2 = solution.encode(input2);
        System.out.println("Encode " + encoded2);
        List<String> decoded2 = solution.decode(encoded2);
        System.out.println("Decoded " + decoded2);

    }
}
