284. Peeking Iterator
https://leetcode.com/problems/peeking-iterator/

Difficulty: Medium
Contributors: Admin
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

Hint:

Think of "looking ahead". You want to cache the next element.
Is one variable sufficient? Why or why not?
Test your design with call order of peek() before next() vs next() before peek().
For a clean implementation, check out Google's guava library source code.
Follow up: How would you extend your design to be generic and work with all types, not just integer?

Hide Company Tags Google Apple Yahoo
Hide Tags Design
Hide Similar Problems (M) Binary Search Tree Iterator (M) Flatten 2D Vector (M) Zigzag Iterator

referred to : https://github.com/google/guava/blob/703ef758b8621cfbab16814f01ddcc5324bdea33/guava-gwt/src-super/com/google/common/collect/super/com/google/common/collect/Iterators.java#L1125

other solutions that only used one variable
https://www.hrwhisper.me/leetcode-peeking-iterator/
https://segmentfault.com/a/1190000003794961
