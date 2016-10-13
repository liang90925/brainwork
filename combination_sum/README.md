39. Combination Sum   QuestionEditorial Solution  My Submissions

Difficulty: Medium
Contributors: Admin
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
Snapchat Uber

referred to : http://www.jiuzhang.com/solutions/combination-sum/


other
http://blog.csdn.net/linhuanmars/article/details/20828631
https://simpleandstupid.com/2014/10/23/combination-sum-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
典型的DFS递归题，一个注意的知识点是Java对于所有的object都是pass by reference，
但是Java对method的arguments是pass by value的。
Java does manipulate objects by reference, and all object variables are references.
However, Java doesn’t pass method arguments by reference; it passes them by value.
为了澄清这个概念，可以读这个帖子：http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
http://www.cnblogs.com/springfor/p/3884294.html


########QUESTIONS########
# 1. What is the complexity of the DFS recursive program
