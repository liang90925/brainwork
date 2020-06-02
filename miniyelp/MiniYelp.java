import java.util.*;
import java.util.stream.Collectors;

/**
 * Definition of Location:
 * class Location {
 *     public double latitude, longitude;
 *     public static Location create(double lati, double longi) {
 *         // This will create a new location object
 *     }
 * };
 * Definition of Restaurant
 * class Restaurant {
 *     public int id;
 *     public String name;
 *     public Location location;
 *     public static Restaurant create(String name, Location location) {
 *         // This will create a new restaurant object,
 *         // and auto fill id
 *     }
 * };
 * Definition of Helper
 * class Helper {
 *     public static get_distance(Location location1, Location location2) {
 *         // return distance between location1 and location2.
 *     }
 * };
 * class GeoHash {
 *     public static String encode(Location location) {
 *         // return convert location to a GeoHash string
 *     }
 *     public static Location decode(String hashcode) {
 *          // return convert a GeoHash string to location
 *     }
 * };
 */
public class MiniYelp {
//    public class Restaurant {
//        public int id;
//        public String name;
//        public Location location;
//        public static Restaurant create(String name, Location location) {
//
//        }
//    };
    public class Location {
        double latitude;
        double longitude;
        public Location(double lat, double lng) {
            this.latitude = lat;
            this.longitude = lng;
        }
    }
    class Node {
        public double distance;
        public Restaurant restaurant;
        public Node(double d, Restaurant r) {
            distance = d;
            restaurant = r;
        }
    }

    private static final double[] BASE32_PRECISIONS =
            {2500, 630, 78, 20, 2.4, 0.61, 0.076, 0.01911, 0.00478, 0.0005971, 0.0001492, 0.0000186};
    private NavigableMap<String, Restaurant> hashToRestaurant = new TreeMap<>();
    private Map<Integer, String> idToHashKey = new TreeMap<>();


    public MiniYelp() {
        // initialize your data structure here.
    }

    // @param name a string
    // @param location a Location
    // @return an integer, restaurant's id
    public int addRestaurant(String name, Location location) {
        // Write your code here
        Restaurant restaurant = Restaurant.create(name, location);
        String hashcode = GeoHash.encode(location) + "." + restaurant.id;
        idToHashKey.put(restaurant.id, hashcode);
        hashToRestaurant.put(hashcode, restaurant);
        return restaurant.id;
    }

    // @param restaurant_id an integer
    public void removeRestaurant(int restaurant_id) {
        // Write your code here
        if (idToHashKey.containsKey(restaurant_id)) {
            String hashKey = idToHashKey.get(restaurant_id);
            idToHashKey.remove(restaurant_id);
            if (hashToRestaurant.containsKey(hashKey)) {
                hashToRestaurant.remove(hashKey);
            }
        }
    }

    // @param location a Location
    // @param k an integer, distance smaller than k miles
    // @return a list of restaurant's name and sort by
    // distance from near to far.
    public List<String> neighbors(Location location, double k) {
        // Write your code here
        int commonLen = getCommonLen(k);
        String commonHashKey = GeoHash.encode(location).substring(0, commonLen);
        List<Node> nodeList = new ArrayList<>();

        for (Map.Entry<String, Restaurant> entry:
                hashToRestaurant.subMap(commonHashKey, true, commonHashKey + "{", true).entrySet()
        ) {
            String key = entry.getKey();
            Restaurant value = entry.getValue();
            double distance = Helper.get_distance(location, value.location);
            if (distance <= k)
                nodeList.add(new Node(distance, value));
        }
        nodeList.sort((a, b) -> Double.compare(a.distance,b.distance));
        return nodeList.stream().map(node -> node.restaurant.name).collect(Collectors.toList());
    }

    private int getCommonLen(double k) {
        for (int j = 0; j < BASE32_PRECISIONS.length; j++) {
            if (k > BASE32_PRECISIONS[j]) {
                return j;
            }
        }
        return 12;
    }
};
