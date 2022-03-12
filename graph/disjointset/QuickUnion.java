package disjointset;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickUnion implements DisjointSet {

    // Root array (values - parents)
    private final int[] roots;

    public QuickUnion(int size) {
        roots = IntStream.range(0, size).toArray();
    }

    /**
     * O(N)
     */
    @Override
    public int find(int x) {
        if (x == roots[x]) {
            return x;
        }

        return find(roots[x]);
    }

    /**
     * O(N)
     */
    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            roots[rootY] = rootX;
        }
    }

    /**
     * O(N)
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
