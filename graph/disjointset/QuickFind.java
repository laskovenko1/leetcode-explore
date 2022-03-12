package disjointset;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickFind implements DisjointSet {

    // Root array (values - roots)
    private final int[] roots;

    public QuickFind(int size) {
        roots = IntStream.range(0, size).toArray();
    }

    /**
     * O(1)
     */
    @Override
    public int find(int x) {
        return roots[x];
    }

    /**
     * O(N)
     */
    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        for (int idx = 0; idx < roots.length; idx++) {
            if (roots[idx] == rootY) {
                roots[idx] = rootX;
            }
        }
    }

    /**
     * O(1)
     */
    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    @Override
    public int[] getRoots() {
        return Arrays.copyOf(roots, roots.length);
    }
}
