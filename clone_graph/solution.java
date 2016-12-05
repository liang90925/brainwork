/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

 public class Solution {
   public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
     if (node == null) {
       return node;
     }

     // step 1, use bfs to get all nodes and store them in a List
     List<UndirectedGraphNode> graphNodes = getAllNodes(node);

     // step 2, create a map with old node as key, and create the copy of the old node as the value
     Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<>();
     for (UndirectedGraphNode graphNode : graphNodes) {
       nodeMap.put(graphNode, new UndirectedGraphNode(graphNode.label));
     }

     // step 3, copy the neighbors.
     for (UndirectedGraphNode graphNode : graphNodes) {
       UndirectedGraphNode newNode = nodeMap.get(graphNode);
       for (UndirectedGraphNode neighbor : graphNode.neighbors) {
         UndirectedGraphNode newNeighbor = nodeMap.get(neighbor);
         newNode.neighbors.add(newNeighbor);
       }
     }

     return nodeMap.get(node);
   }

   private List<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
     Set<UndirectedGraphNode> nodeSet = new HashSet<>();
     Queue<UndirectedGraphNode> nodeQ = new LinkedList<>();
     nodeQ.offer(node);
     while (!nodeQ.isEmpty()) {
       UndirectedGraphNode currNode = nodeQ.poll();
       nodeSet.add(currNode);
       for (UndirectedGraphNode neighborNode : currNode.neighbors) {
         if (!nodeSet.contains(neighborNode)) {
           nodeQ.offer(neighborNode);
         }
       }
     }
     return new ArrayList<>(nodeSet);
   }
 }
