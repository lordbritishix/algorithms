package com.quitevis.algorithms.binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by lordbritishix on 26/04/15.
 */
public class BinaryTreeTest {
    private BinaryTree tree;

    @Before
    public void beforeEachTests() {
        tree = new BinaryTree();
    }

    @Test
    public void getPathWithMaximumResultReturnsCorrectResult() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7= new Node(7);
        Node node8= new Node(8);

        parent.left = node1;
        parent.right = node2;

        node1.left = node3;
        node2.left = node6;
        node2.right = node7;

        node6.left =  node8;

        node3.left = node4;
        node3.right = node5;

        List<Node> result = tree.getPathWithMaxSum(parent);

        assertThat(result.toString(), is("[0, 2, 7]"));
    }

    @Test
    public void getPathWithMaximumResultReturnsCorrectResultForAmazonValues() {
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node8 = new Node(8);
        Node node4 = new Node(4);
        Node node7 = new Node(7);
        Node node2 = new Node(2);
        Node node2neg = new Node(-2);
        Node node1 = new Node(1);

        node3.left= node5;
        node3.right = node8;
        node5.left = node4;
        node5.right = node7;
        node8.right = node2;
        node7.left = node2neg;
        node2.left = node1;

        List<Node> result = tree.getPathWithMaxSum(node3);
        assertThat(result.toString(), is("[3, 8, 2, 1]"));
    }

    @Test
    public void getPathWithMaximumResultReturnsCorrectResultForOneNode() {
        Node parent = new Node(1);

        List<Node> result = tree.getPathWithMaxSum(parent);

        String path = Arrays.toString(result.toArray());
        assertThat(path, is("[1]"));
    }

    @Test
    public void getPathWithMaximumResultReturnsCorrectResultForEmpty() {
        List<Node> result = tree.getPathWithMaxSum(null);

        assertThat(result.toString(), is("[]"));
    }

    @Test
    public void getPathWithMaximumResultReturnsCorrectResultForOneBranch() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        parent.left = node1;
        node1.right = node2;
        node2.left = node3;


        List<Node> result = tree.getPathWithMaxSum(parent);

        String path = Arrays.toString(result.toArray());
        assertThat(path, is("[0, 1, 2, 3]"));
    }

}
