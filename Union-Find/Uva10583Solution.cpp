#include <iostream>

class UnionFind {
private:
    int n;
    int *parent;
    int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
public:
    bool isConnected(int a, int b) {
        return find(a) == find(b);
    }

    void connect(int a, int b) {
        int rootA = find(a), rootB = find(b);
        parent[rootA] = rootB;
    }

    int nClass() {
        int num = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) {
                ++num;
            }
        }
        return num;
    }

    UnionFind(int n) {
        this->parent = new int[n];
        this->n = n;
        for (int i = 0; i < n; ++i) {
            this->parent[i] = i;
        }
    }
};

int main() {
    int n, m;
    int nCase = 0, x, y;
    for (;;) {
        std::cin >> n >> m;
        if (n == 0 && m == 0) {
            break;
        }
        UnionFind *uf = new UnionFind(n);
        for (int i = 0; i < m; ++i) {
            std::cin >> x >> y;
            x--; y--;
            uf->connect(x, y);
        }
        std::cout << "Case " << ++nCase << ": " << uf->nClass() << "\n";
    }
    return 0;
}