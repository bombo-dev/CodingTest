# [기초-종합] 주사위 2개 던지기

n, m = map(int, input().split())

for i in range(n):
    for j in range(m):
        print(i + 1, j + 1)