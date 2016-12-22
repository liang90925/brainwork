
public class Logger {
  Map<String, Integer> mesgToTsMap;

  /** Initialize your data structure here. */
  public Logger() {
    mesgToTsMap = new HashMap<>();
  }

  /**
    return true if the message should be printed in the given stamp,
    otherwise return false
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity
  */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (message == null || message.length() == 0 || timestamp < 0) {
      return false;
    }
    if (mesgToTsMap.containsKey(message)) {
      if ((timestamp - mesgToTsMap.get(message)) < 10) {
        return false;
      }
    }
    mesgToTsMap.put(message, timestamp);
    return true;
  }
}
