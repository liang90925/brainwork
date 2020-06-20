https://www.lintcode.com/problem/standard-bloom-filter


556. Standard Bloom Filter
中文English
Implement a standard bloom filter. Support the following method:

StandardBloomFilter(k) The constructor and you need to create k hash functions.
add(string) Add a string into bloom filter.
contains(string) Check a string whether exists in bloom filter.
Example
Example1

Input:
    StandardBloomFilter(3)
    add("lint")
    add("code")
    contains("lint")
    contains("world")
Output: [true,false]
Example2

Input:
    StandardBloomFilter(10)
    add("hello")
    contains("hell")
    contains("helloa")
    contains("hello")
    contains("hell")
    contains("helloa")
    contains("hello")
Output: [false,false,true,false,false,true]

https://www.jiuzhang.com/solution/standard-bloom-filter/

