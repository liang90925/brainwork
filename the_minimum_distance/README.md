
https://www.lintcode.com/problem/the-minium-distance

1364. the minium distance
中文English
You are now given a two-dimensional tabular graph , in which each grid contains a integer num.

If num is - 2, it means this grid is the starting grid. If num is - 3, it means this grid is the ending grid. If num is - 1, it means this grid has an obstacle on it and you can't move to it. If num is a positive number or 0，you can walk normally on it.

In each move you can travel from one grid to another if and only if they're next to each other or they contain the same positive number num. The cost of each move is 1.

Now you are asked to find the lowest cost of travelling from the starting grid to the ending grid. If the ending grid could not be reached, print -1.

Example
Example
Input:[[1,0,-1,1],[-2,0,1,-3],[2,2,0,0]]
Output:3
In this example,you can reach the ending grid through these moves:
First, move up from the starting grid to the grid that contains the number 1. Second, move to the grid with the same number at the top right.
Finally, move down to the ending grid. There are three moves in total, so the minimun cost will be 3.

Notice
It is guaranteed that the maxium number of rows and columns is 400, and the number in each grid will not exceed 50.

https://www.jiuzhang.com/solution/the-minium-distance/