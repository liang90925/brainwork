174. Dungeon Game  
https://leetcode.com/problems/dungeon-game/

Difficulty: Hard
Contributors: Admin
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

Hide Company Tags Microsoft
Hide Tags Binary Search Dynamic Programming
Hide Similar Problems (M) Unique Paths (M) Minimum Path Sum

referred to :
主要是要想到从右后往左前写， 此题跟其他的题目，比如unique path的写法正好相反
http://www.cnblogs.com/grandyang/p/4233035.html
https://segmentfault.com/a/1190000003884349
http://www.programcreek.com/2014/03/leetcode-dungeon-game-java/
http://blog.csdn.net/likecool21/article/details/42516979
http://bookshadow.com/weblog/2015/01/07/leetcode-dungeon-game/

check http://www.jiuzhang.com/solutions/dungeon-game/ for other问法
