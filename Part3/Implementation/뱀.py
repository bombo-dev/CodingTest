board_size = int(input())

board = [[0] * (board_size + 2) for _ in range(board_size + 2)]

apple_count = int(input())

for _ in range(apple_count):
    a, b = map(int, input().split())
    board[a][b] = 1

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

time = 0
direction = 0
x, y = 1, 1
index = 0

turn_count = int(input())
turn_board = []

for _ in range(turn_count):
    X, c = input().split()
    turn_board.append((int(X), c))


def turn(direction, c):
    if c == 'L':
        direction -= 1
        direction = direction % 4
    else:
        direction += 1
        direction = direction % 4

    return direction


while time <= 10000:
    time += 1

    if turn_board[index][0] == time:
        direction = turn(direction, turn_board[index][1])
        if index != turn_count - 1:
            index += 1

    nx, ny = x + dx[direction], y + dy[direction]

    if board[nx][ny] == 1:
        board[nx][ny] = 0
        board[x][y] = 2
        x, y = nx, ny
    else:
        x, y = nx, ny

    if nx < 1 or nx > board_size or ny < 1 or ny > board_size or board[nx][ny] == 2:
        print(time)
        break


