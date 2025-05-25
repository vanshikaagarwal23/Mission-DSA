import java.util.*;

// Tree node class
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class TopViewBinaryTree {

    public static void topView(Node root) {
        if (root == null) return;

        // Map to store HD and first node at that HD
        Map<Integer, Integer> topViewMap = new TreeMap<>();

        // Queue for BFS: stores pairs of (node, horizontal distance)
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // If this HD is not yet in map, add it (first encountered node at HD)
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            if (node.left != null) queue.add(new Pair(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair(node.right, hd + 1));
        }

        // Print the top view
        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
        }
    }

    // Helper class to hold node and its horizontal distance
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Sample usage and tree creation
    public static void main(String[] args) {
        /*
         Example tree:
                 1
               /   \
              2     3
               \   / \
                4 5   6
        Top view: 2 1 3 6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        topView(root);  // Output: 2 1 3 6
    }
}
