import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardGame {
    private static final char[] prefixes = new char[]{'+', '-', '='};
    private static final String[][] letters = new String[][]{
            {"A", "B", "C"},
            {"AA", "BB", "CC"},
            {"AAA", "BBB", "CCC"}};

    public List<String> getAHand(String[] cards) {
        int len = cards.length;
        // parse the card
        Map<String, Integer> cardCntMap = new HashMap<>();

        for (String card: cards) {
            if (!cardCntMap.containsKey(card)) {
                cardCntMap.put(card, 0);
            }
            cardCntMap.put(card, cardCntMap.get(card) + 1);
        }

        List<String> result = new ArrayList<>();
        cardCntMap.forEach((key, value) -> {
            if (value == 3) {
                for (int i = 0; i < 3; i++) {
                    result.add(key);
                }
            }
        });

        if (result.isEmpty()) {
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    String card1 = cards[i];
                    String card2 = cards[j];
                    // if prefix is same
                    StringBuilder sb = new StringBuilder();
                    // Determine the prefix for the target card
                    sb.append(findTargetPrefix(card1, card2));
                    // Determine the letters for the target card
                    sb.append(findTargetLetters(card1.substring(1), card2.substring(1)));

                    if (cardCntMap.containsKey(sb.toString())) {
                        result.add(card1);
                        result.add(card2);
                        result.add(sb.toString());
                        return result;
                    }
                }
            }
        } else {
            return result;
        }

        return result;
    }

    public String findTargetPrefix(String card1, String card2) {
        if (card1.charAt(0) == card2.charAt(0)) {
            String result = String.valueOf(card1.charAt(0));
            return result;
        } else {
            for (char prefix : prefixes) {
                if (card1.charAt(0) != prefix && card2.charAt(0) != prefix) {
                    return String.valueOf(prefix);
                }
            }
        }
        return "";
    }

    public String findTargetLetters(String letter1, String letter2) {
        if (letter1.length() == letter2.length()) {
            if (!letter1.equals(letter2)) {
                int letterSize = letter1.length();
                for (String content: letters[letterSize - 1]) {
                    if (!letter1.equals(content)
                            && !letter2.equals(content)) {
                        return content;
                    }
                }
            }
        } else {
            // Determine the size of the target cards' letter
            int letterSize = 0;
            for (int n = 1; n <= 3; n++) {
                if (letter1.length() != n && letter2.length() != n) {
                    letterSize = n;
                    break;
                }
            }
            // Determine type of letter
            int col = 0;
            if (letter1.charAt(0) == letter2.charAt(0)) {
                for (int k = 0; k < 3; k++) {
                    if (letter1.charAt(0) == letters[0][k].charAt(0)) {
                        col = k;
                        break;
                    }
                }
            } else {
                for (int k = 0; k < 3; k++) {
                    if (letter1.charAt(0) != letters[0][k].charAt(0)
                            && letter2.charAt(0) != letters[0][k].charAt(0)) {
                        col = k;
                        break;
                    }
                }
            }
            return letters[letterSize - 1][col];
        }
        return "";
    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        List<String> result1 = cardGame.getAHand(new String[] {
                "-A", "-B", "-BB", "+C", "-C", "-CC", "=CCC"
        });
        System.out.println(result1);

        List<String> result2 = cardGame.getAHand(new String[] {
                "-A", "-BB", "+C", "-C", "-CC", "=CCC"
        });
        System.out.println(result2);

    }
}
