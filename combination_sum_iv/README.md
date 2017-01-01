377. Combination Sum IV
https://leetcode.com/problems/combination-sum-iv/

Difficulty: Medium
Contributors: Admin
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

Hide Company Tags Google Snapchat Facebook
Hide Tags Dynamic Programming
Hide Similar Problems (M) Combination Sum

use dynamic Programming:
referred to:
https://www.hrwhisper.me/leetcode-combination-sum-iv/
http://www.jiuzhang.com/solutions/combination-sum-iv/
http://bookshadow.com/weblog/2016/07/25/leetcode-combination-sum-iv/

对于follow up
if negative numbers are allowed in the given array, there could be infinite combinations;
we need to add limitation that only positive or negative numbers or none of them can have duplicates;
and we can use dfs to solve the problem
