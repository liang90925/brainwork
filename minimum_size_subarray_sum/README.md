[窗口类题目]
209. Minimum Size Subarray Sum   

Difficulty: Medium
Contributors: Admin
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

Facebook


基本解法： 枚举起始和终止窗口 然后计算sum O(n^2)

solution 是指针移动做法 复杂度O(n) (JZQH5-1:14)

类似题目
Longest Substring Without Repeating Characters
Minimum Window Substring
Longest Substring with At Most Two Distinct Characters
Longest Substring with At Most K Distinct Characters
