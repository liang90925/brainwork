import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition of Trip:
 * public class Trip {
 *     public int id; // trip's id, primary key
 *     public int driver_id, rider_id; // foreign key
 *     public double lat, lng; // pick up location
 *     public Trip(int rider_id, double lat, double lng);
 * }
 * Definition of Helper
 * class Helper {
 *     public static double get_distance(double lat1, double lng1,
 double lat2, double lng2) {
 *         // return distance between (lat1, lng1) and (lat2, lng2)
 *     }
 * };
 */
public class MiniUber {
    public class Trip {
        public int id; // trip's id, primary key
        public int driver_id, rider_id; // foreign key
        public double lat, lng; // pick up location
        public Trip(int rider_id, double lat, double lng){
            this.id = rider_id;
            this.lat = lat;
            this.lng = lng;
        }
    }
    public class Location {
        double latitude;
        double longitude;
        public Location(double lat, double lng) {
            this.latitude = lat;
            this.longitude = lng;
        }
    }

    private static final Map<Integer, Location> driver2Location = new HashMap<>();
    private static final Map<Integer, Trip> driver2Trip = new HashMap<>();

    public MiniUber() {
        // initialize your data structure here.
    }

    // @param driver_id an integer
    // @param lat, lng driver's location
    // return matched trip information if there have matched rider or null
    public Trip report(int driver_id, double lat, double lng) {
        // Write your code here
        if (driver2Trip.containsKey(driver_id)) {
            return driver2Trip.get(driver_id);
        }
        Location location = new Location(lat, lng);
        driver2Location.put(driver_id, location);
        return null;
    }

    // @param rider_id an integer
    // @param lat, lng rider's location
    // return a trip
    public Trip request(int rider_id, double lat, double lng) {
        // Write your code here
        double distance = -1;
        int driver_id = -1;
        for (Map.Entry<Integer, Location> entry:driver2Location.entrySet()) {
            Location loc = entry.getValue();
            double proximity = Helper.get_distance(loc.latitude, loc.longitude, lat, lng);
            if (distance == -1 || proximity < distance) {
                distance = proximity;
                driver_id = entry.getKey();
            }
        }
        if ( driver_id == -1) {
            return null;
        }
        Trip trip = new Trip(rider_id, lat, lng);
        trip.driver_id = driver_id;
        driver2Trip.put(driver_id, trip);
        driver2Location.remove(driver_id);
        return trip;
    }
}
