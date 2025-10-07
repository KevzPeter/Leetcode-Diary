class UnionFind:
    def __init__(self, size: int):
        self.parent = {i: i for i in range(1, size + 1)}  # Each node points to itself initially
        self.rank = {i: 0 for i in range(1, size + 1)}  # All ranks start at 0

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  # Path compression
        return self.parent[x]

    def union(self, x: int, y: int) -> bool:
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x == root_y:
            return False  # Cycle detected

        # Union by rank
        if self.rank[root_x] > self.rank[root_y]:
            self.parent[root_y] = root_x
        elif self.rank[root_x] < self.rank[root_y]:
            self.parent[root_x] = root_y
        else:
            self.parent[root_y] = root_x
            self.rank[root_x] += 1

        return True


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        uf = UnionFind(1000)  # Adjust size if needed

        for a, b in edges:
            if not uf.union(a, b):
                return [a, b]  # First edge causing a cycle

        return [-1, -1]  # Should never reach here in a valid input
