import sys

input = sys.stdin.readline

# INF 도달할 수 없는 거리
INF = int(1e9)

# n = Node, m = Edge
n, m = map(int, input().split())

start = int(input())

# graph initializing
graph = [[] for i in range(n + 1)]

# visited Table Initializing
visited = [False] * (n + 1)

# distance table initializing
distance = [INF] * (n + 1)

# graph initializing
for _ in range(m):
    n, m, k = map(int, input().split())
    graph[n].append((m, k))


# get smallest node
def get_smallest_node():

    # min_value initializing
    min_value = INF

    # index == 0 : not used index
    index = 0

    # search smallest node index
    for i in range(1, n + 1):
        if(distance[i] < min_value and not visited[i]):
            min_value = distance[i]
            index = i

    return index

def dijkstra(start):

    # Start Node Initializing
    distance[start] = 0
    visited[start] = True

    for i in graph[start]:
        distance[i[0]] = i[1]

        # 도달한거지 방문한게 아님
        # visited[i[0]] = True

    for i in range(n - 1):
        smallest_node = get_smallest_node()
        visited[smallest_node] = True

        for j in graph[smallest_node]:
            if distance[j[0]] > distance[j[0]] + j[1]:
                distance[j[0]] = distance[j[0]] + j[1]

dijkstra(start)

for i in range(1, n + 1):

    if distance[i] == INF:
        print("무한")
    else:
        print(distance[i])




