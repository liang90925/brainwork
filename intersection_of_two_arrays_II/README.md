https://www.lintcode.com/problem/intersection-of-two-arrays-ii/

548. Intersection of Two Arrays II
中文English
Given two arrays, write a function to compute their intersection.

Example
Example1

Input: 
nums1 = [1, 2, 2, 1], nums2 = [2, 2]
Output: 
[2, 2]
Example2

Input: 
nums1 = [1, 1, 2], nums2 = [1]
Output: 
[1]
Challenge
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Notice
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.


https://www.jiuzhang.com/solution/intersection-of-two-arrays-ii/


how to answer the follow up questions:
1. What if the given array is already sorted? How would you optimize your algorithm?
2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

-如果给定的数组已经排序了怎么办?如何优化算法?
双指针算法，复杂度大概在O( max(len(nums1), len(nums2)) )

-如果nums1的大小比num2的小怎么办?哪种算法更好?
nums1如果很小的话
nums1使用map记录，nums2遍历

-如果nums2的元素存储在磁盘上，并且内存受到限制，以至于不能一次将所有元素加载到内存中，该怎么办?
同第二个问题的解决方案，nums2顺序加载到内存，遍历完了就去掉