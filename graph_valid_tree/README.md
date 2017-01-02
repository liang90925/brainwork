261. Graph Valid Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 26603
Total Submissions: 73035
Difficulty: Medium
Contributors: Admin
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Hide Company Tags Google Facebook Zenefits
Hide Tags Depth-first Search Breadth-first Search Graph Union Find
Hide Similar Problems (M) Course Schedule (M) Number of Connected Components in an Undirected Graph

referred to : https://aaronice.gitbooks.io/lintcode/content/union_find/graph_valid_tree.html
for bfs and dfs verions

union_find_simple_version referred to : http://www.cnblogs.com/grandyang/p/5257919.html
solution_union_find_another_version referred to : https://segmentfault.com/a/1190000003791051

other: http://www.jiuzhang.com/solutions/graph-valid-tree/ (没有看懂这个union find 的写法)
samehere https://aaronice.gitbooks.io/lintcode/content/union_find/graph_valid_tree.html
