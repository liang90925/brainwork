https://leetcode.com/problems/word-search/
79. Word Search

Difficulty: Medium
Contributors: Admin
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Microsoft Bloomberg Facebook

referred to : http://www.jiuzhang.com/solutions/word-search/

DFS, 注意单词不能重复那块儿的处理。还有isExist的写法， 虽然第一个start = 0的check会重复但是这样的写法比较清楚。
https://leetcode.com/problems/word-search/solution/
原始版本和leetcode上答案一样更清楚些

backtracking template
https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2793/


Complexity Analysis
Time Complexity:
O(N⋅4^L) where 
N is the number of cells in the board and 
L is the length of the word to be matched.

For the backtracking function, 
its execution trace would be visualized as a 4-ary tree, 
each of the branches represent a potential exploration in the corresponding direction. 
Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 4-nary tree, which is about 4^L
We iterate through the board for backtracking, 
i.e. there could be N times invocation for the backtracking function in the worst case.
As a result, overall the time complexity of the algorithm would be O(N⋅4^L).

Space Complexity: 
O(L) where L is the length of the word to be matched.
The main consumption of the memory lies in the recursion call of the backtracking function. 
The maximum length of the call stack would be the length of the word. 
Therefore, the space complexity of the algorithm is O(L).