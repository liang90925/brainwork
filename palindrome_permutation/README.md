266. Palindrome Permutation   
https://leetcode.com/problems/palindrome-permutation/

Difficulty: Easy
Contributors: Admin
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:
Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?

Hide Company Tags Google Uber Bloomberg
Hide Tags Hash Table
Hide Similar Problems (M) Longest Palindromic Substring (E) Valid Anagram (M) Palindrome Permutation II (E) Longest Palindrome

refer to :
http://blog.csdn.net/pointbreak1/article/details/48766113
https://segmentfault.com/a/1190000003790181

 注意hint里面的内容，不要单纯的以为把所有的而可能性列出来然后一一判断是不是permutation，
 因为此题只是问有没有可能，要注意palindrome的特点，只要满足了特点就可以，不需要知道具体是哪种组合可以构成palindrome
