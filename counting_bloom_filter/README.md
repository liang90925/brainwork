https://www.lintcode.com/problem/counting-bloom-filter

555. Counting Bloom Filter
中文English
Implement a counting bloom filter. Support the following method:

add(string). Add a string into bloom filter.
contains(string). Check a string whether exists in bloom filter.
remove(string). Remove a string from bloom filter.
Example
Example1

Input:
CountingBloomFilter(3)
add("lint")
add("code")
contains("lint") 
remove("lint")
contains("lint") 

Output: 
[true,false]
Example2

Input:
CountingBloomFilter(3)
add("lint")
add("lint")
contains("lint")
remove("lint")
contains("lint")

Output: 
[true,true]

https://www.jiuzhang.com/solution/counting-bloom-filter/
