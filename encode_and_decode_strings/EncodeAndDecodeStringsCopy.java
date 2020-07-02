import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStringsCopy {
    // Encodes string length to bytes string
    public String intToString(String s) {
        int x = s.length();
        char[] bytes = new char[4];
        for(int i = 3; i > -1; --i) {
            bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(intToString(s));
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes bytes string to integer
    public int stringToInt(String bytesStr) {
        int result = 0;
        for(char b : bytesStr.toCharArray())
            result = (result << 8) + (int)b;
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, n = s.length();
        List<String> output = new ArrayList();
        while (i < n) {
            int length = stringToInt(s.substring(i, i + 4));
            i += 4;
            output.add(s.substring(i, i + length));
            i += length;
        }
        return output;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStringsCopy solution = new EncodeAndDecodeStringsCopy();
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
