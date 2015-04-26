package com.quitevis.algorithms.bst;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import edu.princeton.cs.algs4.Queue;

/**
 * Data structure where:
 * 1. Left Node is less than Parent Node
 * 2. Right Node is greater than Parent Node
 * 
 * @author lordbritishix
 *
 */
public class BinarySearchTree {
    private Logger log = LoggerFactory.getLogger(BinarySearchTree.class);
    private Node root;
    
    /**
     * Cases
     * 1. If value is equal, do nothing
     * 2. If value is less than parent, left
     * 3. If value is greater than parent, right
     * 
     * @param value
     */
    public void insert(int value) {
        root = put(root, value);
    }
    
    private Node put(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        
        if (value < node.value) {
            node.left = put(node.left, value);
        }
        else if (value > node.value) {
            node.right = put(node.right, value);
        }
        else {
            node.value = value;
        }
        
        return node;
        
    }
    
    public void delete(int value) {
        root = delete(root, value);
        return;
    }

    private Node delete(Node node, int value) {
        Node current = node;
        if (current == null) {
            return null;
        }
        
        if (value < current.value) {
            current.left = delete(current.left, value);
        }
        else if (value > current.value) {
            current.right = delete(current.right, value);
        }
        else {
            if (current.right == null) {
                return current.left;
            }
            
            if (current.left == null) {
                return current.right;
            }
            
            Node t = current;
            current = min(t.right);
            current.right = deleteMin(t.right);
            current.left = t.left;
        }
        
        return current;
    }
    
    public Node min() {
        return min(root);
    }
    
    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        
        if (node.left == null) {
            return node;
        }
        
        return min(node.left);
    }
    
    public void deleteMin() {
        if (root != null) {
            root = deleteMin(root);
        }
    }
    
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        
        node.left = deleteMin(node.left);
        
        return node;
    }
    
    public void inorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        inorder(node.left, list);
        list.add(node.value);
        inorder(node.right, list);
    }
    
    
    public void levelOrder(List<Integer> list) {
        if (root == null) {
            return;
        }
        
        Queue<Node> currentLevel = new Queue<Node>();

        currentLevel.enqueue(root);
        
        while (!currentLevel.isEmpty()) {
            Node current = currentLevel.dequeue();
            
            if (current != null) {
                list.add(current.value);
                currentLevel.enqueue(current.left);
                currentLevel.enqueue(current.right);
            }
        }
    }
    
    @Override
    public String toString() {
        //Performs in-order traversal to output a sorted list
        List<Integer> list = Lists.newArrayList();
        inorder(root, list);
        
        return Arrays.toString(list.toArray());
    }
}
