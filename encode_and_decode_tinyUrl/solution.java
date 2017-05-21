// base62 version
public class Codec {
  private long index = 0;
  private String base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private HashMap<String, Long> longUrlToInx = new HashMap<>();
  private HashMap<Long, String> inxToLongUrl = new HashMap<>();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    if (longUrlToInx.containsKey(longUrl)) {
      long inx = longUrlToInx.get(longUrl);
      return convertToBase62(inx);
    }

    index++;
    longUrlToInx.put(longUrl, index);
    inxToLongUrl.put(index, longUrl);

    String shortUrl = convertToBase62(index);
    return shortUrl;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    long index = convertToIndex(shortUrl);
    return inxToLongUrl.get(index);
  }

  public String convertToBase62(long inx) {
    String str = "";
    while (inx > 0) {
      int temp = (int) inx % 62;
      inx /= 62;
      str = base62.charAt(temp) + str;
    }
    return str;
  }

  public long convertToIndex(String shortUrl) {
    int val = 0;
    for (int i = 0; i < shortUrl.length(); i++) {
      val = val*62 + base62.indexOf(shortUrl.charAt(i));
    }
    return val;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
