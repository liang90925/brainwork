251. Flatten 2D Vector  QuestionEditorial Solution  My Submissions

Difficulty: Medium
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Hint:

How many variables do you need to keep track?
Two variables is all you need. Try with x and y.
Beware of empty rows. It could be the first few rows.
To write correct code, think about the invariant to maintain. What is it?
The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
Not sure? Think about how you would implement hasNext(). Which is more complex?
Common logic in two different places should be refactored into a common method.
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.

Google Airbnb Twitter Zenefits

https://segmentfault.com/a/1190000003791233
http://blog.csdn.net/pointbreak1/article/details/48823513
http://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
http://buttercola.blogspot.com/search/label/Airbnb

The <solution_with_remove> introduced three variables, one 2D List, one int for col, one int for row
and also that version include the Remove solution and also has the main part for testing.

The <solution_using_iterator> introduced only two variables, both use iterator, one to iterate over the outer list, the other one iterate the inner list.
For this one, I have the remove function using just the iterator's own remove(), and not sure how to test it.
