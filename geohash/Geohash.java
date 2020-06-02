public class Geohash {


    private static final String BASE32 = "0123456789bcdefghjkmnpqrstuvwxyz";
    /*
     * @param latitude: one of a location coordinate pair
     * @param longitude: one of a location coordinate pair
     * @param precision: an integer between 1 to 12
     * @return: a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        // write your code here
        int len = ((precision + 1) / 2 ) * 5;
        String latInBinary = getInBinary(latitude, -90, 90, len);
        String lngInBinary = getInBinary(longitude, -180, 180, len);

        StringBuilder latLngInBinary = new StringBuilder();
        for (int i = 0; i < len; i++) {
            latLngInBinary.append(lngInBinary.charAt(i));
            latLngInBinary.append(latInBinary.charAt(i));
        }

        StringBuilder latLngInBase32 = new StringBuilder();
        for (int i = 0; i < 2*len; i += 5) {
            // Note that when parseInt, add the radix 2 otherwise it's based on 10
            int value = Integer.parseInt(latLngInBinary.substring(i, i + 5), 2);
            latLngInBase32.append(BASE32.charAt(value));
        }
        return latLngInBase32.substring(0, precision);

    }

    private String getInBinary(double val, double left, double right, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            double mid = (left + right) / 2;
            if (val > mid) {
                sb.append("1");
                left = mid;
            } else {
                sb.append("0");
                right = mid;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Geohash geohash = new Geohash();
        geohash.encode(39.92816697, 116.38954991, 12);
        System.out.println(geohash.encode(39.92816697, 116.38954991, 12));
    }
}
