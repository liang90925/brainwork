238. Product of Array Except Self  
https://leetcode.com/problems/product-of-array-except-self/

Difficulty: Medium
Contributors: Admin
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

Hide Company Tags Amazon LinkedIn Apple Facebook Microsoft
Hide Tags Array
Hide Similar Problems (H) Trapping Rain Water (M) Maximum Product Subarray (H) Paint House II

referred to :
http://bookshadow.com/weblog/2015/07/16/leetcode-product-array-except-self/
https://segmentfault.com/a/1190000003768224
http://www.cnblogs.com/grandyang/p/4650187.html

解题思路：
首先想到的思路是计算全部数字的乘积，然后分别除以num数组中的每一个数（需要排除数字0）。然而，题目要求不能使用除法。
下面的解法非常巧妙，参考LeetCode Dicuss
链接地址：https://leetcode.com/discuss/46104/simple-java-solution-in-o-n-without-extra-space
由于output[i] = (x0 * x1 * ... * xi-1) * (xi+1 * .... * xn-1)

因此执行两趟循环：
第一趟正向遍历数组，计算x0 ~ xi-1的乘积
第二趟反向遍历数组，计算xi+1 ~ xn-1的乘积

真的跟trapping water 很想。。。两边走， 算是two pointer的题目
