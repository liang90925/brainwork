472. Concatenated Words  
https://leetcode.com/problems/concatenated-words/

Difficulty: Hard
Contributors: fishercoder
Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.
Hide Tags Dynamic Programming Trie Depth-first Search
Hide Similar Problems (H) Word Break II


the trie version referred to :
http://bookshadow.com/weblog/2016/12/18/leetcode-concatenated-words/ though it's python version

the dfs only version referred to :
http://www.learn4master.com/interview-questions/leetcode/leetcode-concatenated-words and the time is actually faster than the trie one, probably when the input has more words and each words has more length, the trie one will be faster
