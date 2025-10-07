from typing import List


class UnionFind:
    def __init__(self, n: int):
        self.parent = [i for i in range(n * n)]
        self.rank = [0] * (n * n)
        self.size = [1] * (n * n)

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int):
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x != root_y:
            if self.rank[root_x] > self.rank[root_y]:
                self.parent[root_y] = root_x
                self.size[root_x] += self.size[root_y]
            elif self.rank[root_x] < self.rank[root_y]:
                self.parent[root_x] = root_y
                self.size[root_y] += self.size[root_x]
            else:
                self.parent[root_y] = root_x
                self.rank[root_x] += 1
                self.size[root_x] += self.size[root_y]


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        uf = UnionFind(n)

        # Step 1: Union adjacent 1s
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    index = i * n + j
                    for x, y in [(i + 1, j), (i, j + 1)]:
                        if 0 <= x < n and 0 <= y < n and grid[x][y] == 1:
                            uf.union(index, x * n + y)

        # Step 2: Find the size of the largest island
        max_size = 0
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    max_size = max(max_size, uf.size[uf.find(i * n + j)])

        # Step 3: Check each 0 cell to see the potential island size if we change it to 1
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    seen = set()
                    size = 1  # Change this 0 to 1
                    for x, y in [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]:
                        if 0 <= x < n and 0 <= y < n and grid[x][y] == 1:
                            root = uf.find(x * n + y)
                            if root not in seen:
                                size += uf.size[root]
                                seen.add(root)
                    max_size = max(max_size, size)

        return max_size
