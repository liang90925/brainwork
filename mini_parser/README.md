385. Mini Parser

Difficulty: Medium
Contributors: Admin
Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.

Tags Airbnb

referred to: http://www.jiuzhang.com/solutions/mini-parse/
方法：
1. use the help of stack to  do iteration
2. Instead of use index (start/end) to get the number, use the StringBuilder to get number is simple and not easy to mess up.

other:
stack: https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
switch: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
empty a string builder: http://stackoverflow.com/questions/5192512/how-can-i-clear-or-empty-a-stringbuilder
http://www.programcreek.com/2014/08/leetcode-mini-parser-java/
http://www.cnblogs.com/grandyang/p/5771434.html (solution 1 used recursive, can take a look at this and try it by yourself)
