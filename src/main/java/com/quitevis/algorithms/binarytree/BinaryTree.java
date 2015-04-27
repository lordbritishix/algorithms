package com.quitevis.algorithms.binarytree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Various binary tree algorithms
 *
 * Created by lordbritishix on 26/04/15.
 */
public class BinaryTree {
    private Logger log = LoggerFactory.getLogger(BinaryTree.class);

    public List<Node> getPathWithMaxSum(Node node) {
        List<Node> result = new ArrayList<Node>();
        getPathWithMaxSum(node, new ArrayList<Node>(), result, 0);

        return result;
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
