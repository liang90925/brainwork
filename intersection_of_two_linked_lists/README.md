160. Intersection of Two Linked Lists  QuestionEditorial Solution  My Submissions
Total Accepted: 94491
Total Submissions: 309451
Difficulty: Easy
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.


Amazon Microsoft Bloomberg Airbnb

referred answer : http://www.cnblogs.com/yuzhangcmu/p/4128794.html
for solution and solution2;

there is another answer: http://www.jiuzhang.com/solutions/intersection-of-two-linked-lists/
The solution will connect end of lista to start of listb, which changed the structure of the list. But the method behind it is to use the find the start of a circle solution.
