
https://leetcode.com/problems/longest-common-subsequence/solution/

1143. Longest Common Subsequence
Medium

1478

18

Add to List

Share
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.



Time complexity : O(M⋅N).
We're solving M⋅N subproblems. Solving each subproblem is an O(1)O(1) operation.

Space complexity : O(M⋅N).
We'e allocating a 2D array of size M⋅N to save the answers to subproblems.

https://leetcode.com/problems/longest-common-subsequence/solution/
The last DP solution is solving it from the backwards and it also worked.
