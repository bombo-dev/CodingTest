# BFS 한 노드부터 참조 순서

from collections import deque

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


# 1. 시작 노드를 큐에 담는다.
# 2. 시작 노드를 방문 처리 한다.
# 3. 시작 노드를 큐에서 뽑는다
# 4. 큐에서 뽑은 노드와 인접한 노드중에 방문하지 않은 것이 있으면 방문처리하고 큐에 추가한다.
# 5. 2 ~ 4 를 반복한다.

def BFS(graph, v, visited):
    queue = deque([v])
    visited[v] = True
    while queue:
        v = queue.popleft()
        print(v, end = ' ')
        for i in graph[v]:
            if visited[i] == False:
                visited[i] = True
                queue.append(i)

BFS(graph, 1, visited)