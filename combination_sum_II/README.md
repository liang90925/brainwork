40. Combination Sum II   QuestionEditorial Solution  My Submissions

Difficulty: Medium
Contributors: Admin
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Snapchat


referred to :http://www.jiuzhang.com/solutions/combination-sum-ii/

other
http://www.cnblogs.com/yuzhangcmu/p/4141347.html
http://blog.csdn.net/github_27609763/article/details/50210993
http://blog.welkinlan.com/2015/11/05/combination-sum-i-ii-iii-leetcode-java/
https://simpleandstupid.com/2014/10/23/combination-sum-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
典型的DFS递归题，一个注意的知识点是Java对于所有的object都是pass by reference，
但是Java对method的arguments是pass by value的。
Java does manipulate objects by reference, and all object variables are references.
However, Java doesn’t pass method arguments by reference; it passes them by value.
为了澄清这个概念，可以读这个帖子：http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
http://www.cnblogs.com/springfor/p/3884294.html
