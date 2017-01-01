152. Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/

Difficulty: Medium
Contributors: Admin
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Hide Company Tags LinkedIn
Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Maximum Subarray (E) House Robber (M) Product of Array Except Self


http://www.jiuzhang.com/solutions/maximum-product-subarray/

a good explanation at http://blog.csdn.net/worldwindjp/article/details/39826823
其实子数组乘积最大值的可能性为：累乘的最大值碰到了一个正数；或者，累乘的最小值（负数），碰到了一个负数。所以每次要保存累乘的最大（正数）和最小值（负数）。同时还有一个选择起点的逻辑，如果之前的最大和最小值同当前元素相乘之后，没有当前元素大（或小）那么当前元素就可作为新的起点。例如，前一个元素为0的情况，{1,0,9,2}，到9的时候9应该作为一个最大值，也就是新的起点，{1,0,-9,-2}也是同样道理，-9比当前最小值还小，所以更新为当前最小值。
这种方法只需要遍历一次数组即可，算法时间复杂度为O(n)。
