[窗口类题目]

3. Longest Substring Without Repeating Characters

Difficulty: Medium
Contributors: Admin
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Amazon Adobe Bloomberg Yelp
(H) Longest Substring with At Most Two Distinct Characters


http://www.jiuzhang.com/solutions/longest-substring-without-repeating-characters/
using hashset and catch the result using two indexes.

基本解法： 枚举起始和终止窗口 然后维护一个hashset判断重复与否(O(n))
优化解法： O(n), 利用窗口移动  前向型指针 (JZQH5-1:35)

类似题目：
minimum_size_subarray_sum
Minimum Window Substring
Longest Substring with At Most Two Distinct Characters
Longest Substring with At Most K Distinct Characters
