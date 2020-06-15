public class WeightedUnionFindImpl implements UnionFind {
    int[] parent, size;

    private int find(int a) {
        while (parent[a] != a) {
            a = parent[a];
        }
        return a;
    }

    public WeightedUnionFindImpl(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public void union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }

    @Override
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}