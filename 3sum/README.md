15. 3Sum   

Difficulty: Medium
Contributors: Admin
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

Amazon Microsoft Bloomberg Facebook Adobe

// two levels of for/while loop;
// loop through to select a first element;
// and then loop through the rest for other two elements just like 2sum
// two things need to be taken care;
// 1. sort the input nums
// 2. take care of the duplicate numbers (skip them)
http://www.jiuzhang.com/solutions/3sum/
