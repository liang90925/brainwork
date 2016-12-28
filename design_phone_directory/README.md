379. Design Phone Directory   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 5888
Total Submissions: 20098
Difficulty: Medium
Contributors: Admin
Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
Hide Company Tags Google
Hide Tags Linked List Design

referred to :
https://segmentfault.com/a/1190000007203378
a simple and easy to understand version;

use a queue to store available numbers and a hashset to store used number;
when get, poll() from the queue and add to the hashset
when check, check if the hashset contains
when release, remove the number from the hashset and then add to queue
similar approach http://www.programcreek.com/2014/08/leetcode-design-phone-directory-java/

other solutions like bitset, can take a look when have time
https://discuss.leetcode.com/topic/53102/java-ac-solution-with-bitset-and-efficient-get-comments

this blog contains more solutions
http://massivealgorithms.blogspot.com/2016/08/leetcode-379-design-phone-directory.html
