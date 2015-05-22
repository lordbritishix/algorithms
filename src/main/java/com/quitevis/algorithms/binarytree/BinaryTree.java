package com.quitevis.algorithms.binarytree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Various binary tree algorithms
 *
 * Created by lordbritishix on 26/04/15.
 */
public class BinaryTree {
    private Logger log = LoggerFactory.getLogger(BinaryTree.class);

    public List<Node> getPathWithMaxSum(Node node) {
        List<Node> result = new ArrayList<>();
        getPathWithMaxSum(node, new ArrayList<Node>(), result, 0);

        return result;
    }

    /**
     * Checks if a binary tree is foldable.
     * It is foldable if the left and right subtrees of the root are structure wise mirror image of each other
     *
     * e.g.
     *        10
     *       /  \
     *     7     15
     *      \    /
     *      9  11
     *
     * foldable = isFoldable(left) && isFoldable(right)
     */
    public boolean isFoldable(Node root) {
        if (root == null) {
            return true;
        }

        return isFoldable(root.left, root.right);
    }

    private boolean isFoldable(Node left, Node right) {
        //Base case #1: If this is true, this means this subtree is foldable and we've reached the leaf either the
        //inner (left.right, right.left) or the outer (left.left, right.right) subtree
        if ((left == null) && (right == null)) {
            return true;
        }

        //Base case #2: If either one is missing, it is not foldable
        if ((left == null) || (right == null)) {
            return false;
        }

        //If both nodes exist, then check if the inner and the outer set of nodes are foldable
        return isFoldable(left.left, right.right) && isFoldable(left.right, right.left);
    }

    public String bfs(Node root) {
        StringBuilder ret = new StringBuilder();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            ret.append(node.value);
            ret.append(", ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        log.trace("BFS Path: {}", ret.toString().trim());

        return ret.toString().trim();
    }

    /**
     * 2-stack approach
     */
    public String zigzag(Node root) {
        StringBuilder ret = new StringBuilder();

        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        boolean ltr = false;

        currentLevel.push(root);

        while (!currentLevel.isEmpty()) {
            Node node = currentLevel.pop();

            ret.append(node.value);
            ret.append(", ");

            if (ltr) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            else {
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                ltr = !ltr;

                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }

        return ret.toString().trim();
    }

    public List<Node> getPath(Node root, Node target) {
        List<Node> result = new ArrayList<>();
        getPath(root, target, result);

        return result;
    }

    /**
     * Max is Math.max(parent, Math.max(max(left), max(right)))
     */
    public int getMax(Node root) {
        if (root == null) {
            return 0;
        }

        int left = getMax(root.left);
        int right = getMax(root.right);

        return Math.max(root.value, Math.max(left, right));
    }


    /**
     * Height is 1 + max(height(left), height(right))
     */
    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * Gets the immediate ancestor between two nodes
     * 1. Find the path from root to node1 and node2
     * 2. Store path 1 to hash table
     * 3. Check if any of node2's node in path is present in path 1. If it is, that's the common ancestor
     */
    public Node getCommonAncestor(Node root, Node node1, Node node2) {
        Map<Node, Integer> node1Path = new HashMap<>();

        List<Node> path1 = getPath(root, node1);
        List<Node> path2 = getPath(root, node2);

        for (Node node : path1) {
            node1Path.put(node, node.value);
        }

        for (Node node : path2) {
            if (node1Path.containsKey(node)) {
                return node;
            }
        }

        return root;
    }

    /**
     * Gets the path from root to target
     * It works by performing pre-order traversal on the tree
     * If the node is found, true is returned and the nodes on that
     * call stack gets added to the path
     */
    private boolean getPath(Node root, Node target, List<Node> path) {
        if (root == null) {
            return false;
        }

        //If found, return true
        if (root == target) {
            log.trace("Found path");
            log.trace("Adding to path: {}", root.value);

            path.add(root);
            return true;
        }

        boolean retLeft = getPath(root.left, target, path);
        boolean retRight = getPath(root.right, target, path);

        //If found, always return true and add to path
        if (retLeft || retRight ) {
            log.trace("Adding to path: {}", root.value);

            path.add(root);
            return true;
        }

        return false;
    }

    /**
     * Gets the path, from root to leaf, containing the maximum sum
     * Uses pre-order traversal to store nodes to the list. The path from
     * root to leaf is defined by the index 0 - (level - 1) on the list
     *
     * @param node Subtree to process
     * @param data Stores the current path
     * @param result Stores the path with the most sum
     * @param level Stores the current level of the tree
     */
    private void getPathWithMaxSum(Node node, List<Node> data,
                                   List<Node> result, int level) {
        int currentLevel = level;

        if (node == null) {
            return;
        }

        data.add(currentLevel, node);
        currentLevel++;
        log.trace("Level: {}, Pushing node: {}", currentLevel, node);
        if ((node.left == null)  && (node.right == null)) {
            //Check if sum of the existing result is less than the sum of
            //the current path
            //If it is, replace the existing result with the current path
            if (getSum(result) < getSum(data)) {
                result.clear();

                //Current node path is from 0 to currentLevel - 1, so only copy that
                for (int x = 0; x < currentLevel; ++x) {
                    result.add(data.get(x));
                }

                log.trace("Result so far: {}", result.toString());
            }
        }
        else {
            getPathWithMaxSum(node.left, data, result, currentLevel);
            getPathWithMaxSum(node.right, data, result, currentLevel);
        }
    }



    private int getSum(List<Node> nodes) {
        int sum = 0;
        for (Node node : nodes) {
            sum += node.value;
        }

        return sum;
    }
}
