https://www.lintcode.com/problem/inverted-index/

中文English
Create an inverted index with given documents.

Example
Given a list of documents with id and content. (class Document)
Return an inverted index (HashMap with key is the word and value is a list of document ids).
Example 1:

Input:
[
  {
    "id": 1,
    "content": "This is the content of document 1 it is very short"
  },
  {
    "id": 2,
    "content": "This is the content of document 2 it is very long bilabial bilabial heheh hahaha ..."
  },
]
Output:
{
   "This": [1, 2],
   "is": [1, 2],
   ...
}
Example 2:

Input:
[
  {
    "id": 1,
    "content": "you are young"
  },
  {
    "id": 2,
    "content": "you are handsome"
  },
]
Output:
{
   "are": [1, 2],
   ...
}
Notice
Ensure that data does not include punctuation.


https://www.jiuzhang.com/solution/inverted-index/
