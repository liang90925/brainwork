https://www.lintcode.com/problem/rat-jump

1861. Rat Jump
中文English
There is a mouse jumping from the top of a staircase with height n. This mouse can jump 1, 3 or 4 steps in an even number of jumps and 1, 2, or 4 steps in an odd number of times. Some steps have glue,if the mouse jump those steps,it will be directly stuck and cannot continue to jump.You need to solve how many ways the mouse can reach the ground ( level 0 ) from the top of this staircase.It also can be reached if it exceeds the ground. For example, jumping from 1 to -1 is another plan for jumping from 1 to 0.The state of the stairs with or without glue is input from high to low, that is, arr [0] represents that there is no glue at the current mouse position.

Example
Example1:

Input:[0,0,0]
Output:5
Explanation:
There are 3 steps.
The step 2  is the starting point without glue.
Step 1, no glue.
Step 0, no glue.
The mouse jump plans is:
2--odd(1)-->1--even(1)-->0
2--odd(1)-->1--even(3)-->-2
2--odd(1)-->1--even(4)-->-3
2--odd(2)-->0
2--odd(4)-->-2
Example2:

Input:[0,0,1,0]
Output:3
Explanation:
There are 4 steps.
The step 3  is the starting point without glue.
Step 2, no glue.
Step 1, have glue.
Step 0, no glue.
Notice
2<=n<=50000
arr[i]=1 means there is glue on the step, 0 means there is no glue
The input guarantees the highest steps and the lowest is 0
The answer needs to be modulo by 1e9 + 7

https://www.jiuzhang.com/solution/rat-jump/#tag-highlight-lang-java
I created the version, a bit different from the answer.