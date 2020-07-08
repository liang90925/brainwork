import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        if (numerator < 0 || denominator < 0) {
            result.append("-");
        }

        long numLong = Math.abs(Long.valueOf(numerator));
        long denLong = Math.abs(Long.valueOf(denominator));

        result.append(numLong / denLong);

        long remainder = numLong % denLong;
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();

        while(remainder != 0) {
            if (!remainderMap.containsKey(remainder)) {
                remainderMap.put(remainder, result.length());
                remainder *= 10;
                result.append(remainder / denLong);

                remainder %= denLong;
            } else {
                result.insert(remainderMap.get(remainder), "(");
                result.append(")");
                break;
            }
        }

        return result.toString();
    }
}
