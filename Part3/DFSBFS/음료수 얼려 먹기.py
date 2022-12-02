n, m = map(int, input().split())

graph = []
result = 0

for i in range(n):
    graph.append(list(map(int, input())))


def dfs(row, col):
    if row <= -1 or row >= n or col <= -1 or col >= m:
        return False

    if graph[row][col] == 0:
        graph[row][col] = 1
        dfs(row, col + 1)
        dfs(row + 1, col)
        dfs(row, col - 1)
        dfs(row - 1, col)
        return True
    return False


for i in range(n):
    for j in range(m):
        if dfs(i, j):
            result += 1

print(result)