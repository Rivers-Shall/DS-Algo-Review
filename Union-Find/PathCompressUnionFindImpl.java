public class PathCompressUnionFindImpl implements UnionFind {
    int[] parent;

    public PathCompressUnionFindImpl(int n) {
        parent = new int[n];
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
        }
    }
    
    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    @Override
    public void union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        parent[rootA] = rootB;
    }

    @Override
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}