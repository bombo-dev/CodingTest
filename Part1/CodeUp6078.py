# [기초-종합] 원하는 문자가 입력될 때까지 반복 출력하기

a = 'a'
n = ord('q')

while(ord(a) != n):
    a = input()
    print(a)