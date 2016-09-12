https://siddontang.gitbooks.io/leetcode-solution/content/array/find_peak_element.html

Using binary search to fulfill the requirement of O(logn);
if mid value larger than both left and right value, then return the index of it.
if mid value smaller than the left one, that means there must be a peak value at the left side.
if mid value smaller than the right one, that means there must be a peak value at the right side.
note: need to take care of the boundary case of mid.
