https://www.lintcode.com/problem/mini-yelp/description?_from=ladder&&fromId=75

Design a simple yelp system. Support the following features:

Add a restaurant with name and location.
Remove a restaurant with id.
Search the nearby restaurants by given location.
A location is represented by latitude and longitude, both in double. A Location class is given in code.

Nearby is defined by distance smaller than k Km .

Restaurant class is already provided and you can directly call Restaurant.create() to create a new object. Also, a Helper class is provided to calculate the distance between two location, use Helper.get_distance(location1, location2).

A GeoHash class is provided to convert a location to a string. Try GeoHash.encode(location) to convert location to a geohash string and GeoHash.decode(string) to convert a string to location.

Press here to Learn about GeoHash

Have you met this question in a real interview?
Example
Example 1

Input:
addRestaurant("Lint Cafe", 10.4999999, 11.599999)
addRestaurant("Code Cafe", 10.4999999, 11.512109)
neighbors(10.5, 11.6, 6.7)
removeRestaurant(1)
neighbors(10.5, 9.6, 6.7)

Output:
1
2
["Lint Cafe"]
[]

Explanation:
When add 2 restaurants, we return 1 and 2.
When searching neighbors, first time we find Lint Cafe and the second time we find nothing.
Example 2

Input:
addRestaurant("Lint Cafe", 10.4999999, 11.599999)
addRestaurant("Code Cafe", 10.4999999, 11.512109)
neighbors(10.5, 11.6, 6.7)
removeRestaurant(1)
neighbors(10.5, 11.6, 6.7)

Output:
1
2
["Lint Cafe"]
[]

Explanation
When searching neighbors the second time, the "Lint Cafe" has been removed.

https://www.jiuzhang.com/solution/mini-yelp/

需要知道对应的geohash的precision， map的定义， 如何利用geohash， 返回的顺序 等等