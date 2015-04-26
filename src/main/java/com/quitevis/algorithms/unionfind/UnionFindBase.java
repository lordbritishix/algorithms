package com.quitevis.algorithms.unionfind;

public abstract class UnionFindBase {
    private int[] nodes;

    public UnionFindBase(int n) {
        nodes = new int[n];

        for (int x = 0; x < n; ++x) {
            nodes[x] = x;
        }
    }

    public UnionFindBase(int[] n) {
        nodes = n;
    }

    public int getValue(int node) {
        return nodes[node];
    }

    public void setValue(int node, int value) {
        nodes[node] = value;
    }

    public int getLength() {
        return nodes.length;
    }

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();

        for (int x = 0; x < nodes.length; ++x) {
            ret.append(nodes[x]);
            ret.append(",");
        }

        if (ret.length() <= 0) {
            return "";
        } else {
            return ret.substring(0, ret.length() - 1);
        }
    }

    /**
     * Checks if a and b are connected components
     *
     * @param a
     * @param b
     * @return true if a and b are connected components
     */
    public abstract boolean isConnected(int a, int b);

    /**
     * Connects node a to node b
     *
     * @param a
     * @param b
     */
    public abstract void union(int a, int b);

}
