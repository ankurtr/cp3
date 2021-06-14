package com.algos;

import java.util.ArrayList;
import java.util.stream.IntStream;

class UnionFind {
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new ArrayList<>(N);
        rank = new ArrayList<>(N);
        setSize = new ArrayList<>(N);
        numSets = N;

        IntStream.range(0, N).forEach(i -> {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        });
    }

    public int findSet(int i) {
        if (i == p.get(i))
            return i;
        else return findSet(p.get(i));
    }

    private boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            numSets--;

            int x = findSet(i);
            int y = findSet(j);

            if (rank.get(x) > rank.get(y)) {
                p.set(y, x);
                setSize.set(x, setSize.get(x) + setSize.get(y));
            } else {
                p.set(x, y);
                setSize.set(x, setSize.get(x) + setSize.get(y));
                if (rank.get(x) == rank.get(y)) {
                    rank.set(y, rank.get(y) + 1);
                }
            }
        }
    }

    public int numDisjointSets() {
        return numSets;
    }

    public int sizeOfSet(int i) {
        return setSize.get(i);
    }
}

public class ConnectedComponents {
}
