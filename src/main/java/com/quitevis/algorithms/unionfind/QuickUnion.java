package com.quitevis.algorithms.unionfind;

/**
 * Lazy approach
 * <p/>
 * Relies on parent-child relationship between nodes
 * <p/>
 * isConnected = O(n) isConnected = O(n)
 *
 * @author lordbritishix
 */
public class QuickUnion extends UnionFindBase {
    private int[] size;

    public QuickUnion(int n) {
        super(n);
        size = new int[n];

        for (int x = 0; x < n; ++x) {
            size[x] = 1;
        }
    }

    public QuickUnion(int[] n) {
        super(n);
    }

    /**
     * Root is found if node == getValue(node)
     *
     * @param node
     * @return
     */
    private int getRoot(int node) {
        int val = node;
        while (getValue(val) != val) {
            val = getValue(val);
        }

        return val;
    }

    /**
     * If node a and node b has the same parent, they are connected
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public boolean isConnected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    /**
     * Set node a's parent to node b
     *
     * @param a
     * @param b
     */
    @Override
    public void union(int a, int b) {
        int rootA = getRoot(a);
        int rootB = getRoot(b);

        if (rootA == rootB) {
            return;
        }

        if (size[rootA] < size[rootB]) {
            setValue(rootA, rootB);
            size[rootB] += size[rootA];
        } else {
            setValue(rootB, rootA);
            size[rootA] += size[rootB];
        }
    }
}
