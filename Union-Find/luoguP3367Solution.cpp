#include <iostream>

using namespace std;

class UnionFind {
private:
    int* parent;
    int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
public:
    void connect(int a, int b) {
        int rootA = find(a), rootB = find(b);
        parent[rootA] = rootB;
    }
    bool isConnected(int a, int b) {
        return find(a) == find(b);
    }
    UnionFind(int n) {
        this->parent = new int[n + 5];
        for (int i = 0; i < n; ++i) {
            this->parent[i] = i;
        }
    }
    ~UnionFind() {
    }
};

int main() {
    int n, m;
    int op, x, y;
    cin >> n >> m;
    UnionFind *uf = new UnionFind(n);
    for (int i = 0; i < m; ++i) {
        cin >> op >> x >> y;
        x--; y--;
        if (op == 1) {
            uf->connect(x, y);
        } else {
            if (uf->isConnected(x, y)) {
                cout << "Y\n";
            } else {
                cout << "N\n";
            }
        }
    }
    return 0;
}