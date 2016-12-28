425. Word Squares   
https://leetcode.com/problems/word-squares/

Difficulty: Hard
Contributors: Admin
Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Hide Company Tags Google
Hide Tags Backtracking Trie
Hide Similar Problems (E) Valid Word Square

referred to following for solution:
https://discuss.leetcode.com/topic/63516/explained-my-java-solution-using-trie-126ms-16-16
created a trie and also for each trieNode, added a new attribute called startedWith list,
it contains the words that started with string from root to current char;

please also check the solution at:https://discuss.leetcode.com/topic/64770/java-dfs-trie-54-ms-98-so-far/7 which didn't use the startwith extra field and is faster;
