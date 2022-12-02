from collections import deque

N, M, K, X = map(int, input().split())

distance = [0] * (N + 1)
graph = [[] for i in range(N + 1)]

for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)

def bfs(distance, graph, X):
    queue = deque([X])

    while(queue):
        v = queue.popleft()
        for i in graph[v]:
            if distance[i] == 0:
                distance[i] = distance[v] + 1
            queue.append(i)


bfs(distance, graph, X)

result = 0
for i in range(len(distance)):
    if distance[i] == K:
        print(i)
        result += 1

if result == 0:
    print(-1)


