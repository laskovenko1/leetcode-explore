package disjointset;

public interface DisjointSet {

    int[] getRoots();

    int find(int x);

    void union(int x, int y);

    boolean connected(int x, int y);
}
