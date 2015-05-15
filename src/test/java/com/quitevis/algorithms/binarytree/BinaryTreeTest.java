package com.quitevis.algorithms.binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
    public void getMaxHeightReturnsCorrectHeight1() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        parent.left = node1;
        parent.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        assertThat(tree.getHeight(parent), is(3));
    }

    @Test
    public void getMaxHeightReturnsCorrectHeight2() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        parent.left = node1;
        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node4.right = node5;
        node5.right = node6;

        assertThat(tree.getHeight(parent), is(7));
    }

    @Test
    public void getMaxHeightReturnsCorrectHeight3() {
        Node parent = new Node(0);

        assertThat(tree.getHeight(parent), is(1));
    }

    @Test
    public void getMaxHeightReturnsCorrectHeight4() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        parent.left = node1;
        parent.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        node5.right = node6;

        assertThat(tree.getHeight(parent), is(6));
    }


    @Test
    public void getMaxReturnsMax1() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        parent.left = node1;
        parent.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        assertThat(tree.getMax(parent), is(6));
    }

    @Test
    public void getMaxReturnsMax2() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        parent.left = node1;
        parent.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node9;

        node7.left = node8;
        assertThat(tree.getMax(parent), is(9));
    }

    @Test
    public void getMaxReturnsMax3() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node9 = new Node(9);

        parent.left = node9;
        parent.right = node3;

        node9.left = node2;
        node9.right = node1;

        assertThat(tree.getMax(parent), is(9));
    }


    @Test
    public void getCommonAncestorReturnsCorrectAncestor1() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        parent.left = node1;
        parent.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node9;

        node7.left = node8;

        assertThat(tree.getCommonAncestor(parent, node3, node4), is(node1));
        assertThat(tree.getCommonAncestor(parent, node5, node1), is(parent));
        assertThat(tree.getCommonAncestor(parent, node8, node9), is(node3));
        assertThat(tree.getCommonAncestor(parent, node8, node4), is(node1));
        assertThat(tree.getCommonAncestor(parent, node8, node6), is(parent));
        assertThat(tree.getCommonAncestor(parent, node8, node7), is(node7));
    }

    @Test
    public void getCommonAncestorReturnsCorrectAncestor2() {
        Node parent = new Node(0);
        assertThat(tree.getCommonAncestor(parent, parent, parent), is(parent));
    }

    @Test
    public void getPathReturnsCorrectPathFromTargetToRoot1() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        parent.left = node1;
        parent.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        List<Node> path = tree.getPath(parent, node5);
        assertThat(path.toString(), is("[5, 2, 0]"));

        path = tree.getPath(parent, node1);
        assertThat(path.toString(), is("[1, 0]"));

        path = tree.getPath(parent, node4);
        assertThat(path.toString(), is("[4, 1, 0]"));
    }

    @Test
    public void getPathReturnsCorrectPathFromTargetToRoot2() {
        Node parent = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        parent.left = node1;

        node1.left = node2;
        node2.left = node3;

        node3.left = node4;
        node4.right = node5;
        node5.right = node6;

        List<Node> path = tree.getPath(parent, node6);

        assertThat(path.toString(), is("[6, 5, 4, 3, 2, 1, 0]"));

        path = tree.getPath(parent, node5);
        assertThat(path.toString(), is("[5, 4, 3, 2, 1, 0]"));

        path = tree.getPath(parent, node1);
        assertThat(path.toString(), is("[1, 0]"));

        path = tree.getPath(parent, parent);
        assertThat(path.toString(), is("[0]"));

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
