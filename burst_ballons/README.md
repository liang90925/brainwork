312. Burst Balloons   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 20936
Total Submissions: 50283
Difficulty: Hard
Contributors: Admin
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google Snapchat
Hide Tags Dynamic Programming Divide and Conquer

referred to : http://bookshadow.com/weblog/2015/11/30/leetcode-burst-balloons/ (this one is easier to be understand)
others:
http://www.cnblogs.com/grandyang/p/5006441.html
https://www.hrwhisper.me/leetcode-burst-balloons/
