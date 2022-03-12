import disjointset.DisjointSet;
import disjointset.QuickFind;
import disjointset.QuickUnion;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        DisjointSet quickUnion = new QuickUnion(SIZE);
        DisjointSet quickFind = new QuickFind(SIZE);

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] elements = IntStream.generate(() -> random.nextInt(SIZE))
                .limit(SIZE * 2)
                .toArray();

        for (int firstIdx = 0; firstIdx < SIZE * 2; firstIdx = firstIdx + 2) {
            quickFind.union(elements[firstIdx], elements[firstIdx + 1]);
            quickUnion.union(elements[firstIdx], elements[firstIdx + 1]);
        }

        System.out.println("Elements: " + Arrays.toString(elements));
        System.out.println("QuickFind:" + Arrays.toString(quickFind.getRoots()));
        System.out.println("QuickUnion:" + Arrays.toString(quickUnion.getRoots()));
    }
}
