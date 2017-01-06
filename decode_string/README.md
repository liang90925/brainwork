
394. Decode String   https://leetcode.com/problems/decode-string/

Difficulty: Medium
Contributors: Admin
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

Hide Company Tags Google
Hide Tags Depth-first Search Stack
Hide Similar Problems (H) Encode String with Shortest Length

dfs referred to https://discuss.leetcode.com/topic/57318/java-simple-recursive-solution
stack: http://www.guoting.org/leetcode/leetcode-394-decode-string/

other
http://www.cnblogs.com/grandyang/p/5849037.html
http://bookshadow.com/weblog/2016/09/04/leetcode-decode-string/
