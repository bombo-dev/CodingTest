# DFS 예제

def dfs(graph, v, visited): # graph : 그래프, v : 탐색 시작 노드, v : 방문 확인 배열
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=' ')

    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트), 인접 행렬 방식
graph = [
    [], # 0번 노드와 연결된 노드
    [2, 3, 8], # 1번 노드와 연결된 노드
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# 각 노드가 방문한 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * 9

dfs(graph, 1, visited)
