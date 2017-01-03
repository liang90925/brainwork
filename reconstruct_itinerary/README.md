332. Reconstruct Itinerary https://leetcode.com/problems/reconstruct-itinerary/

Difficulty: Medium
Contributors: Admin
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Depth-first Search Graph

referred to : https://segmentfault.com/a/1190000005617082
https://discuss.leetcode.com/topic/36370/short-ruby-python-java-c/2
other： http://www.jiuzhang.com/solutions/reconstruct-itinerary/
http://www.cnblogs.com/EdwardLiu/p/5184961.html
http://www.programcreek.com/2015/03/leetcode-reconstruct-itinerary-java/This is an application of Hierholzer’s algorithm to find a Eulerian path.
PriorityQueue should be used instead of TreeSet, because there are duplicate entries.
http://bookshadow.com/weblog/2016/02/05/leetcode-reconstruct-itinerary/
