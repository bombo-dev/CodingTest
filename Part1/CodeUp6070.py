# [기초-조건/선택실행구조] 월 입력받아 계절 출력하기

a = int(input())

if (a // 3) == 1:
    print("spring")
elif (a // 3) == 2:
    print("summer")
elif( a // 3) == 3:
    print("fall")
elif( a // 3) == 4:
    print("winter")
else:
    print("winter")
