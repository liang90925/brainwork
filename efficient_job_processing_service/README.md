https://www.lintcode.com/problem/efficient-job-processing-service

1853. Efficient Job Processing Service
中文English
Twitter is testing a new job processing service called Pigeon.

Pigeon processes any task in double the actual duration of the task and every task has a weight. Also, Pigeon can serve only for a limited duration(maximum runtime) in an hour.

Given the maximum runtime of the Pigon service, the list of tasks with their lengths and weights, determine the maximum total weight that the Pigeon service can achieve in an hour.

The input contains these parameters:

nn: the number of tasks
weightsweights: the weight for every task
taskstasks: the actual duration of every task
pp: maximum runtime for Pigeon in an hour
Example
Example 1

Input:
4
[2,4,4,5]
[2,2,3,4]
15
Output: 10
Explanation:You can run No.0 No.1 and No.2 task. It will cost 2 * (2 + 2 + 3) = 14 minutes and get 2 + 4 + 4 = 10 weight.
Example 2

Input:
3
[3,2,2]
[3,2,2]
9
Output: 4
Explanation:You can run No.1 and No.2 task. It will cost 2 * (2 + 2) = 8 minutes and get 2 + 2 = 4 weight.
Clarification
Every task can be processed only once.

Notice
1 \leq n \leq 10^31≤n≤10
​3
​​ 
1 \leq weights[i] \leq 10^61≤weights[i]≤10
​6
​​ 
1 \leq tasks[i] \leq 1001≤tasks[i]≤100
1 \leq p \leq 10^31≤p≤10
​3
​​ 
https://www.jiuzhang.com/solution/efficient-job-processing-service/
假设最大运行时间为p，总共有n个工作；
空间复杂度为O(p)；
时间复杂度为O(n*p)。


思路
处理任务需要花费两倍时间，因此我们可以把最大运行时间p除以2，这样就能按实际时间考虑。要想得到花费不超过p/2的时间的最大权重和，又每个工作最多只能选择一次，因此我们可以把这题转化成典型的01背包问题。
即：背包容量为p/2，一共有n个物品可供选择，物品i体积为tasks[i]且价值为weights[i]，求最大价值？
令dp[i]表示工作总时间为i时的最大权重之和，那么临界值为dp[0]=0，状态转移方程为：dp\[j] = max(dp\[j], dp\[j - tasks[i]] + weights\[i]);

即 当前最大权值dp[j] 由 过去最大权值 与 选择当前工作 i 后的最大权值 转移而来。

选择当前工作 i 后的最大权值为 工作总时间为 (j - tasks[i]) 的最大权值 加上 工作 i 的权值weights[i]。
答案为最大的dp[i]，i∈[0,p/2]。
