373. Find K Pairs with Smallest Sums https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

Difficulty: Medium
Contributors: Admin
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]

Hide Company Tags Google Uber
Hide Tags Heap
Hide Similar Problems (M) Kth Smallest Element in a Sorted Matrix

referred to: http://glassjar-blog.appspot.com/Article?aid=ag9zfmdsYXNzamFyLWJsb2dyFAsSB0FydGljbGUYgICAgJnShQoM
Idea: maintain a PriorityQueue that has an int array in it, the int array contains, two numbers and the index of the second number;
First build the queue by adding at most K numbers or the most number of combination of numbers in nums1 and nums2[0];
then, do while loop for at most k times, each time, poll the smallest from PQ and put to result, and then add the next smallest number to the PQ.
runtime complexity: O(klog(k))

other: http://blog.csdn.net/yeqiuzs/article/details/51851359
http://www.programcreek.com/2015/07/leetcode-find-k-pairs-with-smallest-sums-java/
