import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BuySell {
    enum Type {
        BUY,
        SELL
    }
    public static class Input {
        int value;
        int share;
        Type type;

        public Input(int value, int share, Type type) {
            this.value = value;
            this.share = share;
            this.type = type;
        }
    }

    public int getMaxNoShare(List<Input> inputs) {
        TreeMap<Integer, Integer> buyPool = new TreeMap<>();
        TreeMap<Integer, Integer> sellPool = new TreeMap<>();

        int result = 0;
        if (inputs == null || inputs.size() == 0) {
            return 0;
        }

        for (Input curr : inputs) {
            if (curr.type == Type.BUY) {
                int cnt = curr.share;
                while (cnt > 0) {
                    Integer sellValue = sellPool.floorKey(curr.value);
                    if (sellValue == null) {
                        break;
                    } else {
                        int sellShare = sellPool.get(sellValue);
                        if (sellShare == cnt) {
                            cnt = 0;
                            sellPool.remove(sellValue);
                        } else if (sellShare > cnt) {
                            cnt = 0;
                            sellPool.put(sellValue, sellShare - cnt);
                        } else {
                            cnt -= sellShare;
                            sellPool.remove(sellValue);
                        }
                    }
                }

                if (cnt > 0) {
                    buyPool.put(curr.value, cnt);
                }

                result += (curr.share - cnt);
            }

            if (curr.type == Type.SELL) {
                int cnt = curr.share;
                while (cnt > 0) {
                    Integer foundInt = buyPool.ceilingKey(curr.value);
                    if (foundInt == null) {
                        break;
                    } else {
                        int buyShare = buyPool.get(foundInt);
                        if (buyShare == cnt) {
                            cnt = 0;
                            buyPool.remove(foundInt);
                        } else if (buyShare > cnt) {
                            cnt = 0;
                            buyPool.put(foundInt, buyShare - cnt);
                        } else {
                            cnt -= buyShare;
                            buyPool.remove(foundInt);
                        }
                    }
                }

                if (cnt > 0) {
                    sellPool.put(curr.value, cnt);
                }

                result += (curr.share - cnt);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        BuySell buySell = new BuySell();
        List<Input> inputs = new ArrayList<>();
        inputs.add(new Input(150, 10, Type.BUY));
        inputs.add(new Input(145, 7, Type.SELL));      //7
        inputs.add(new Input(168, 3, Type.BUY)); // 3
        inputs.add(new Input(155, 5, Type.SELL));       //2
        inputs.add(new Input(166, 8, Type.BUY)); // 8   //3
      //  inputs.add(new Input(158, 1, Type.BUY)); // 1

        int result = buySell.getMaxNoShare(inputs);

        System.out.println("result : " + result);

    }
}
