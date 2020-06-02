import java.util.Arrays;

public class GeohashII {


    private static final String BASE32 = "0123456789bcdefghjkmnpqrstuvwxyz";
    private static final int[] MASKS = new int[]{16, 8, 4, 2, 1};
    /*
     * @param geohash: geohash a base32 string
     * @return: latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        double[] latRange = {-90, 90};
        double[] lngRange = {-180, 180};

        int cnt = 0;
        // write your code here
        for (int i = 0; i < geohash.length(); i++) {
            int value = BASE32.indexOf(geohash.charAt(i));
            for (int j = 0; j < 5; j++) {
                if (cnt % 2 == 0) {
                    refineRange(lngRange, value, j);
                } else {
                    refineRange(latRange, value, j);
                }
                cnt++;
            }
        }
        return new double[]{
                (latRange[0] + latRange[1]) /2,
                (lngRange[0] + lngRange[1]) /2};
    }
    private void refineRange(double[] range, int value, int index) {
        int inBinary = value & MASKS[index];
        if (inBinary == 0) {
            range[1] = (range[0] + range[1]) / 2;
        } else {
            range[0] = (range[0] + range[1]) / 2;
        }
    }

    public static void main(String[] args) {
        GeohashII geohash = new GeohashII();

        System.out.println(Arrays.toString(geohash.decode("wx4g0s")) + " = (lat = 39.92706299 and lng = 116.39465332)");
        System.out.println(Arrays.toString(geohash.decode("w")) + " = (lat = 22.50000000 and lng = 112.50000000)");

    }
}
