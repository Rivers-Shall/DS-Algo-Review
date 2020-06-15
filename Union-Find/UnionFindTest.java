public class UnionFindTest {
    static boolean testUnionFindImpl(UnionFind unionFind) {
        boolean result = true;
        unionFind.union(1, 2);
        unionFind.union(4, 2);
        unionFind.union(9, 7);
        result &= (unionFind.isConnected(1, 2) == true);
        result &= (unionFind.isConnected(1, 4) == true);
        result &= (unionFind.isConnected(2, 9) == false);
        result &= (unionFind.isConnected(6, 8) == false);
        unionFind.union(8, 6);
        unionFind.union(4, 7);
        result &= (unionFind.isConnected(2, 9) == true);
        result &= (unionFind.isConnected(6, 8) == true);
        result &= (unionFind.isConnected(7, 5) == false);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("testUnionFindImpl(PathCompress): " + testUnionFindImpl(new PathCompressUnionFindImpl(10)));
        System.out.println("testUnionFindImpl(Weighted): " + testUnionFindImpl(new WeightedUnionFindImpl(10)));
    }
}