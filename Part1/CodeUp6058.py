# [기초-논리연산] 둘 다 거짓일 경우만 참 출력하기
# not a and not b == not(a or b)

a, b = map(int, input().split())
a = bool(a)
b = bool(b)

print(not (a or b))


