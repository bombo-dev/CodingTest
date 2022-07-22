# 좌표값을 이용한 풀이

ptr = input()

row_num = int(ptr[1])
col_num = int(ord(ptr[0])) - int(ord('a')) + 1

steps = [(-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2)]

result = 0

for step in steps:
    next_row = row_num + step[0]
    next_col = col_num + step[1]

    if(next_row >= 1 and next_row <= 8 and next_col >= 1 and next_col <= 8):
        result += 1

print(result)