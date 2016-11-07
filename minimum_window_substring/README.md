76. Minimum Window Substring

Difficulty: Hard
Contributors: Admin
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

LinkedIn Snapchat Uber Facebook

基本解法： 两层for循环，然后用两个hash表检查下窗口的字符是不是都在target中。O（n^2)
        hash表存char为key，出现的个数为value

优化解法：


类似题目：
Longest Substring Without Repeating Characters
minimum_size_subarray_sum
Longest Substring with At Most Two Distinct Characters
Longest Substring with At Most K Distinct Characters

http://www.jiuzhang.com/solutions/minimum-window-substring/
双指针，动态维护一个区间。尾指针不断往后扫，当扫到有一个窗口包含了所有T的字符后，然后再收缩头指针，直到不能再收缩为止。最后记录所有可能的情况中窗口最小的 O(n)
 (JZQH5-1:40)
