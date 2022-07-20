# [기초-종합] 3 6 9 게임의 왕이 되

a = int(input())

for i in range(1, a+1):
    if(i % 10 == 3):
        print('X', end=' ')
    elif(i % 10 == 6):
        print('X', end=' ')
    elif(i % 10 == 9):
        print('X', end=' ')
    else:
        print(i, end=' ')