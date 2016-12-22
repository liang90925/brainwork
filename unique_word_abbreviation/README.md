
288. Unique Word Abbreviation
https://leetcode.com/problems/unique-word-abbreviation/

Difficulty: Easy
Contributors: Admin
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") ->
false

isUnique("cart") ->
true

isUnique("cane") ->
false

isUnique("make") ->
true

Hide Company Tags Google
Hide Tags Hash Table Design
Hide Similar Problems (E) Two Sum III - Data structure design (M) Generalized Abbreviation

referred to:
http://blog.csdn.net/pointbreak1/article/details/48797961
http://www.cnblogs.com/grandyang/p/5184143.html

Note: The following situation should return true, not false;
dict ["hello", "hello"], word: "hello", should return true;
