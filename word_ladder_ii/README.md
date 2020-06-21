http://www.jiuzhang.com/solutions/word-ladder-ii/
BFS & DFS

121. Word Ladder II
中文English
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, output sequence in dictionary order.
Transformation rule such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
Example
Example 1:

Input：start = "a"，end = "c"，dict =["a","b","c"]
Output：[["a","c"]]
Explanation：
"a"->"c"
Example 2:

Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
Output：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation：
1."hit"->"hot"->"dot"->"dog"->"cog"
2."hit"->"hot"->"lot"->"log"->"cog"
The dictionary order of the first sequence is less than that of the second.
Notice
All words have the same length.
All words contain only lowercase alphabetic characters.
At least one solution exists.

https://www.jiuzhang.com/solution/word-ladder-ii/
感觉写到胃痉挛。。。