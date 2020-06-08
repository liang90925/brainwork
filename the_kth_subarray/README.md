https://www.lintcode.com/problem/the-kth-subarray/description

escription
中文
English
Given an array aa whose length is nn. You can get \frac{n(n+1)}{2}
​2
​
​n(n+1)
​​  subarrays from it. Please calc the sum of each subarray ,sort it in ascending order and then return the kth of them.

1 \leq n \leq 10^51≤n≤10
​5
​​ 
1 \leq a_i \leq 10^91≤a
​i
​​ ≤10
​9
​​ 
1 \leq k \leq \frac{n(n+1)}{2}1≤k≤
​2
​
​n(n+1)
​​ 
Have you met this question in a real interview?  
Example
Example1

Input: 
[2,3,1,4]
6
Output:5
Explanation:
We can get the sum of the subarrays are [1,2,3,4,4(3 + 1), 5(1 + 4), 5(2 + 3), 6(2 + 3 + 1), 8(3 + 1 + 4), 10(2 + 3 + 1 + 4)]. 


https://www.jiuzhang.com/solution/the-kth-subarray/#tag-highlight-lang-java
二分， 要知道二分的条件， 然后要注意long