class UnionFind:
    def __init__(self, n: int):
        self.parent = {}
        self.rank = {}
        self.size = {}
        for i in range(n):
            for j in range(n):
                node = self.get_node_str(i, j)
                self.parent[node] = node
                self.rank[node] = 0
                self.size[node] = 1

    def get_node_str(self, i, j) -> int:
        return str(i) + "R" + str(j) + "C"

    def find(self, x: str) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: str, y: str):
        root_x = self.find(x)
        root_y = self.find(y)

        if self.rank[root_x] > self.rank[root_y]:
            self.parent[root_y] = root_x
        elif self.rank[root_x] < self.rank[root_y]:
            self.parent[root_x] = root_y
        else:
            self.parent[root_y] = root_x
            self.rank[root_x] += 1

        root_x_size = self.size[root_x]
        root_y_size = self.size[root_y]
        self.size[root_x] = root_x_size + root_y_size
        self.size[root_y] = root_x_size + root_y_size


class Solution:
    dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]

    def isValid(self, i, j, n):
        return i >= 0 and i < n and j >= 0 and j < n

    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        uf = UnionFind(n)
        visited = [[0 for i in range(n)] for j in range(n)]

        for i in range(n):
            for j in range(n):
                if visited[i][j] == 0 and grid[i][j] == 1:
                    self.dfs(i, j, grid, visited, uf)
        ans = 1
        water_exists = False
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    water_exists = True
                    surrounding_islands = set([])
                    curr_island_size = 0
                    for dir in self.dirs:
                        x, y = i + dir[0], j + dir[1]
                        if self.isValid(x, y, n) and grid[x][y] == 1:
                            island_str = uf.get_node_str(x, y)
                            island = uf.find(island_str)
                            surrounding_islands.add(island)
                    for island in surrounding_islands:
                        curr_island_size += uf.size[island]
                    if (len(surrounding_islands) > 0):
                        curr_island_size += 1
                    ans = max(ans, curr_island_size)
        return (n * n) if not water_exists else ans

    def dfs(self, i, j, grid, visited, uf):
        visited[i][j] = 1
        curr_node = uf.get_node_str(i, j)
        for dir in self.dirs:
            x, y = i + dir[0], j + dir[1]
            if self.isValid(x, y, len(grid)) and visited[x][y] == 0 and grid[x][y] == 1:
                next_node = uf.get_node_str(x, y)
                uf.union(curr_node, next_node)
                self.dfs(x, y, grid, visited, uf)
        return
