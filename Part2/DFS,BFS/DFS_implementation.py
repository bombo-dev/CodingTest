# DFS 한 노드의 시작부터 참조 순서

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

visited = [False] * 9
stack = []

def DFS(graph, v, visited):
    stack.append(v)
    visited[v] = True
    v = stack.pop()
    print(v, end= ' ')
    for node in graph[v]:
        if visited[node] == False:
            DFS(graph, node, visited)

DFS(graph, 1, visited)
