package com.quitevis.algorithms.bst;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @Before
    public void beforeEachTests() {
        bst = new BinarySearchTree();
    }
    
    @Test
    public void insertProperlyInsertsAnElementToTheList1() {
       bst.insert(9);
       bst.insert(1);
       bst.insert(8);
       bst.insert(7);
       bst.insert(2);
       bst.insert(6);
       bst.insert(3);
       bst.insert(5);
       bst.insert(4);
       
       assertThat(bst.toString(), is("[1, 2, 3, 4, 5, 6, 7, 8, 9]"));
    }

    @Test
    public void insertProperlyInsertsAnElementToTheList2() {
       bst.insert(1);
       bst.insert(1);
       bst.insert(1);
       
       assertThat(bst.toString(), is("[1]"));
    }

    
    @Test
    public void minReturnsSmallestNumberInBst1() {
        bst.insert(9);
        bst.insert(1);
        bst.insert(8);
        bst.insert(7);
        bst.insert(2);
        bst.insert(6);
        bst.insert(3);
        bst.insert(5);
        bst.insert(4);

        assertThat(bst.min().value, is(1));
    }
    
    @Test
    public void minReturnsSmallestNumberInBst2() {
        bst.insert(9);

        assertThat(bst.min().value, is(9));
    }

    @Test
    public void minReturnsSmallestNumberInBst3() {
        assertThat(bst.min(), nullValue());
    }

    @Test
    public void deleteMinDeletsSmallestNumberInBst1() {
        bst.insert(9);
        bst.insert(1);
        bst.insert(8);
        bst.insert(7);
        bst.insert(2);
        bst.insert(6);
        bst.insert(3);
        bst.insert(5);
        bst.insert(4);

        bst.deleteMin();
        assertThat(bst.toString(), is("[2, 3, 4, 5, 6, 7, 8, 9]"));
        
        bst.deleteMin();
        assertThat(bst.toString(), is("[3, 4, 5, 6, 7, 8, 9]"));
    }

    @Test
    public void deleteMinDeletsSmallestNumberInBst2() {
        bst.insert(9);

        bst.deleteMin();
        assertThat(bst.toString(), is("[]"));
    }

    @Test
    public void deleteDeletsNumberInBst1() {
        bst.insert(1);
        bst.insert(8);
        bst.insert(7);
        bst.insert(2);
        bst.insert(6);
        bst.insert(3);
        bst.insert(5);
        bst.insert(4);
        bst.insert(9);
        
        bst.delete(4);
        assertThat(bst.toString(), is("[1, 2, 3, 5, 6, 7, 8, 9]"));
        
        bst.delete(9);
        assertThat(bst.toString(), is("[1, 2, 3, 5, 6, 7, 8]"));
    }

    @Test
    public void deleteDeletsNumberInBst2() {
        bst.insert(9);
        bst.delete(9);
        
        assertThat(bst.toString(), is("[]"));
    }

    @Test
    public void deleteDeletsNumberInBst3() {
        bst.insert(9);
        bst.delete(5);
        
        assertThat(bst.toString(), is("[9]"));
    }

    @Test
    public void levelOrderTraversalTraversesBSTCorrectly1() {
        bst.insert(3);
        bst.insert(10);
        bst.insert(14);
        bst.insert(6);
        bst.insert(1);
        bst.insert(8);
        bst.insert(4);
        bst.insert(13);
        bst.insert(7);
        
        List<Integer> list = Lists.newArrayList();
        bst.levelOrder(list);
        
        assertThat(Arrays.toString(list.toArray()), is("[3, 1, 10, 6, 14, 4, 8, 13, 7]"));
    }
    
    @Test
    public void levelOrderTraversalTraversesBSTCorrectly2() {
        bst.insert(3);
        
        List<Integer> list = Lists.newArrayList();
        bst.levelOrder(list);
        
        assertThat(Arrays.toString(list.toArray()), is("[3]"));
    }

    @Test
    public void levelOrderTraversalTraversesBSTCorrectly3() {
        bst.insert(76);
        bst.insert(41);
        bst.insert(25);
        bst.insert(39);
        bst.insert(67);
        bst.insert(34);
        bst.insert(11);
        bst.insert(49);
        bst.insert(30);
        bst.insert(48);
        
        List<Integer> list = Lists.newArrayList();
        bst.levelOrder(list);
        
        System.out.println(Arrays.toString(list.toArray()));

    }
    
    @Test
    public void levelOrderTraversalTraversesBSTCorrectly4() {
        bst.insert(91);
        bst.insert(50);
        bst.insert(98);
        bst.insert(20);
        bst.insert(71);
        bst.insert(13);
        bst.insert(42);
        bst.insert(58);
        bst.insert(82);
        bst.insert(17);
        bst.insert(41);
        bst.insert(38);
        
        bst.delete(17);
        bst.delete(41);
        bst.delete(50);
        
        List<Integer> list = Lists.newArrayList();
        bst.levelOrder(list);
        
        System.out.println(Arrays.toString(list.toArray()));

    }
}

