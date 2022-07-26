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

# 1. 시작 노드를 스택에 담는다.
# 2. 시작 노드를 방문처리 한다.
# 3. 스택에서 노드를 꺼낸다.
# 4. 노드와 인접한 가장 깊은 노드(최소 숫자)를 스택에 추가하고 방문 표시 한다.
# 5. 3 ~ 4 과정을 스택이 빌 때까지 반복한다.

def DFS(graph, v, visited):
    stack.append(v)
    visited[v] = True
    v = stack.pop()
    print(v, end= ' ')
    for node in graph[v]:
        if visited[node] == False:
            DFS(graph, node, visited)

DFS(graph, 1, visited)
