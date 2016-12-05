139. Word Break  

Difficulty: Medium
Contributors: Admin
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Hide Company Tags Google Uber Facebook Amazon Yahoo Bloomberg Pocket Gems

Dynamic programming!
referred to: http://bangbingsyb.blogspot.com/2014/11/leetcode-word-break-i-ii.html 但是blog中code有错 solution.java 中的答案是修改过可以过的version

other：
http://www.jiuzhang.com/solutions/word-break/, 此version的code比较多，但是有其他的条件加入了 如考虑了dictword里面的最小的单词的长度，这样可以减少code运行时候扫k的次数， 有时间可以尝试写下这个

http://fisherlei.blogspot.com/2013/11/leetcode-word-break-solution.html
