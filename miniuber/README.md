
https://www.lintcode.com/problem/mini-uber/description?_from=ladder&&fromId=75


Support two basic uber features:

Drivers report their locations.
Rider request a uber, return a matched driver.
When rider request a uber, match a closest available driver with him, then mark the driver not available.

When next time this matched driver report his location, return with the rider's information.

You can implement it with the following instructions:

report(driver_id, lat, lng)
return null if no matched rider.
return matched trip information.
request(rider_id, lat, lng)
create a trip with rider's information.
find a closest driver, mark this driver not available.
fill driver_id into this trip.
return trip
This is the definition of Trip in Java:

public class Trip {
    public int id; // trip's id, primary key
    public int driver_id, rider_id; // foreign key
    public double lat, lng; // pick up location
}
Have you met this question in a real interview?
Example
Example 1:

Input:
  report(1, 36.1344, 77.5672)
  report(2, 45.1344, 76.5672)
  request(2, 39.1344, 76.5672)
  report(1, 38.1344, 75.5672)
  report(2, 45.1344, 76.5672)
Output:
  null
  null
  Trip(rider_id: 2, driver_id: 1, lat: 39.1344, lng: 76.5672)
  Trip(rider_id: 2, driver_id: 1, lat: 39.1344, lng: 76.5672)
  null
Example 2:

Input:
  report(1, 36.1344, 77.5672)
  report(2, 45.1344, 76.5672)
  request(2, 39.1344, 76.5672)
  request(3, 78.1344, 134.5672)
Output:
  null
  null
  LOG(INFO): Trip(rider_id: 2, driver_id: 1, lat: 39.1344, lng: 76.5672)
  LOG(INFO): Trip(rider_id: 3, driver_id: 2, lat: 78.1344, lng: 134.5672)

  https://www.jiuzhang.com/solution/mini-uber/
