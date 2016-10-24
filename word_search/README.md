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
