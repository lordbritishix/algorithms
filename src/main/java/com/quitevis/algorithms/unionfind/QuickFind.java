package com.quitevis.algorithms.unionfind;

/**
 * Eager approach
 * <p/>
 * isConnected = O(1) union = O(n)
 *
 * @author lordbritishix
 */
public class QuickFind extends UnionFindBase {
    public QuickFind(int n) {
        super(n);
    }

    public QuickFind(int[] n) {
        super(n);
    }

    @Override
    public boolean isConnected(int a, int b) {
        return getValue(a) == getValue(b);
    }

    @Override
    public void union(int a, int b) {
        int valA = getValue(a);
        int valB = getValue(b);

        if (valA == valB) {
            return;
        }

        for (int x = 0; x < getLength(); ++x) {
            if (getValue(x) == valA) {
                setValue(x, valB);
            }
        }
    }
}
