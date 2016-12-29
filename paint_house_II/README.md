265. Paint House II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 15332
Total Submissions: 41397
Difficulty: Hard
Contributors: Admin
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?

Hide Company Tags Facebook
Hide Tags Dynamic Programming
Hide Similar Problems (M) Product of Array Except Self (H) Sliding Window Maximum (M) Paint House (E) Paint Fence

referred to :
http://www.cnblogs.com/grandyang/p/5322870.html
http://www.programcreek.com/2014/05/leetcode-paint-house-ii-java/

the solution.java created two more one D array, but actually can be reduced to two int variable;
check the solution_less_oneD_array.java for details
and also the twoD array dp created might not be needed, if we modified the input costs array, check the second link for reference
