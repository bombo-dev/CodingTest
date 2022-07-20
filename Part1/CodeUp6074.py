# [기초-반복실행구조] 문자 1개 입력받아 알파벳 출력하기
# print의 end 파라미터에 = ''를 입력하면 print이후에 줄바꿈을 출력하지 않는다.

c = ord(input())
a = ord('a')
while (a <= c):
    print(chr(a), end=' ')
    a += 1
