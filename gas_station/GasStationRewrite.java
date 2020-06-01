import com.sun.deploy.panel.ExceptionListDialog;

public class GasStationRewrite {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas == null || gas.length == 0) {
      return -1;
    }
    if (cost == null || cost.length == 0) {
      return 0;
    }

    int len = gas.length;
    int tempSum = 0;
    int total = 0;
    int index = 0;
    for (int i = 0; i < len; i++) {
      tempSum += gas[i] - cost[i];
      total += gas[i] - cost[i];
      if (tempSum < 0) {
        index = i + 1;
        tempSum = 0;
      }
    }
    return total < 0 ? -1 : index;
  }

  public static void main(String[] args) {
    GasStationRewrite gasStationRewrite = new GasStationRewrite();
    System.out.println(gasStationRewrite.canCompleteCircuit(
            new int[]{1, 1, 3, 1},
            new int[]{2, 2, 1, 1}
    ) + " ===== 2");
    System.out.println(gasStationRewrite.canCompleteCircuit(
            new int[]{1, 1, 3, 1},
            new int[]{2, 2, 5, 1}
    ) + " ===== -1");
  }
}
