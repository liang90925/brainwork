https://www.lintcode.com/problem/squirrel-simulation

873. Squirrel Simulation
中文English
There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.

Example
Example 1:

Input: height = 5, width = 7,
  treePosition = [2, 2],
  squirrelPosition = [4, 4],
  nuts = [[3, 0], [2, 5]]
Output: 12


Example 2:

Input: height = 1, width = 3,
  treePosition = [0,1],
  squirrelPosition = [0,0],
  nuts = [[0,2]]
Output: 3
Notice
All given positions won't overlap.
The squirrel can take at most one nut at one time.
The given positions of nuts have no order.
Height and width are positive integers. 3 <= height * width <= 10,000.
The given positions contain at least one nut, only one tree and one squirrel.

https://www.jiuzhang.com/solution/squirrel-simulation/