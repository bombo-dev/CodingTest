# 게임 개발 정리 코드

N, M = map(int, input().split())

map_visit = [[False] * M for _ in range(N)]
map_position = []
row, col, d = map(int, input().split())
for _ in range(N):
    map_position.append(list(map(int, input().split())))

move_type = [-1, 1, 1, -1]
result = 0

map_visit[row][col] = True

while(True):
    rotation_count = 0
    next_row = 0
    next_col = 0
    for _ in range(len(move_type)):
        next_row = row
        next_col = col

        if d == 0:
            d = 3
        else:
            d -= 1

        if(d == 1 or d == 3):
            next_col = col + move_type[d]
        elif(d == 0 or d == 2):
            next_row = row + move_type[d]

        if(map_visit[next_row][next_col] == False and map_position[next_row][next_col] == 0):
            map_visit[next_row][next_col] = True
            row, col = next_row, next_col
            result += 1
            break

        rotation_count += 1

    if(rotation_count == 4):
        if(d == 1 or d == 3):
            next_col = col - move_type[d]
        elif(d == 0 or d == 2):
            next_row = row - move_type[d]

    if(rotation_count == 4 and map_position[next_row][next_col] == 1):
        break

    elif(rotation_count == 4 and map_position[next_row][next_col] == 0):
        row, col = next_row, next_col

print(result)