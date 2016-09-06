http://blog.csdn.net/foreverling/article/details/49702187
1. solution1: math manipulation n*(n+1)/2 - sum(nums);
2. solution2: bit manipulation; using xor on all numbers and index from 0 to n;
the result will be the missing one. since the result of two same number of xor is 0;
the result of xor of a number and 0 is the number itself.
