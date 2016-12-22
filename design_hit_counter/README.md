362. Design Hit Counter
https://leetcode.com/problems/design-hit-counter/

Difficulty: Medium
Contributors: Admin
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:
HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301);

Follow up:
What if the number of hits per second could be very large? Does your design scale?


Hide Company Tags Dropbox Google
Hide Tags Design
Hide Similar Problems (E) Logger Rate Limiter


The solution can cover the follow up question:
What if the number of hits per second could be very large? Does your design scale?
referred to :http://www.guoting.org/leetcode/leetcode-362-design-hit-counter/

good explanation:
思路:Array
使用两个数组times和hits,times数组里面放的是时间戳,hits数组里面放的是相应时间戳的点击次数,由于只需要统计5分钟(即300秒)以内的点击次数,但是时间戳是有可能大于300的,我们采取的措施是对时间戳取余,当往times数组里面存放时间戳时,如果之前存储的时间戳和现在要存放的不同,说明之前的时间戳已经过期,此时只需把times数组中的时间戳置为当前时间戳,hits数组相应位置置为1;如果相同,说明之前存储的时间戳和现在要存放的相同,只需hits数组里面相应位置增加1。当统计点击次数的时候,我们从前完后遍历一遍times数组,如果times数组中存储的时间戳和当前的时间戳的差值小于300,我们把hits数组里面相应位置的点击次数加起来即可。

solution_queue.java referred to http://www.cnblogs.com/grandyang/p/5605552.html
解法一
