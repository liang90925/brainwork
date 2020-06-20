https://www.lintcode.com/problem/web-crawler/leaderboard

234. Web Crawler
中文English
Implement a webpage Crawler to crawl webpages of http://www.wikipedia.org/. To simplify the question, let's use url instead of the the webpage content.

Your crawler should:

Call HtmlHelper.parseUrls(url) to get all urls from a webpage of given url.
Only crawl the webpage of wikipedia.
Do not crawl the same webpage twice.
Start from the homepage of wikipedia: http://www.wikipedia.org/
Example
Example 1

Input:
    "http://www.wikipedia.org/": ["http://www.wikipedia.org/help/"]
    "http://www.wikipedia.org/help/": []
Output: ["http://www.wikipedia.org/", "http://www.wikipedia.org/help/"]
Example 2

Input:
    "http://www.wikipedia.org/": ["http://www.wikipedia.org/help/"]
    "http://www.wikipedia.org/help/": ["http://www.wikipedia.org/","http://www.wikipedia.org/about/"]
    "http://www.wikipedia.org/about/": ["http://www.google.com/"]

Output: ["http://www.wikipedia.org/", "http://www.wikipedia.org/help/", "http://www.wikipedia.org/about/"]
Notice
You need do it with multithreading.
You can use up to 3 threads


referred to the answer from other contributors
