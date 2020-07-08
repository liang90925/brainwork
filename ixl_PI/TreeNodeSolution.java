
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TreeNodeSolution {


/*
Given a tree of strings, find the string which appears on the greatest number of levels of the tree.

    a
  b.  a
a  a.  b

   a
a. b. b b b b b b
 */
    public class Node {
        String str;
        List<Node> children;

        Node(String str) {
            this.str = str;
            children = new ArrayList<>();
        }
    }

    public String findGreatestString(Node root) {
        if (root == null) {
            return null;
        }
        Map<String, Integer> strCntMap = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        // a
        // b.      a
        // a  a.      b
        // Form the Map with string and count
        while(!que.isEmpty()) {
            int size = que.size(); //3
            int i = 0;
            Set<String> usedString = new HashSet<>();

            while(i < size) { //1
                Node curr = que.poll();    //b , a // a, a
                String val = curr.str;
                if (!usedString.contains(val)) {
                    strCntMap.put(val, strCntMap.getOrDefault(val, 0) + 1); // (a, 3), (b, 2)
                    usedString.add(curr.str); // (a, b)
                }

                for (Node node: curr.children) {
                    que.add(node); //(b)
                }
                i++;
            }
        }

        // Loop over the map and find the max;
        int max = Integer.MIN_VALUE;
        String str = "";

        for (Map.Entry<String, Integer> entry: strCntMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                str = entry.getKey();
            }
        }


        return str;
    }

    static int addNumbers(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;

        sum = addNumbers(a, b);
        System.out.println(sum);
    }
}

