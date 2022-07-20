# [기초-3항연산] 정수 2개 입력받아 큰 값 출력하기
# x if C else y, C = conditional expression
a, b = map(int, input().split())

c = (a if (a >= b) else b)
print(c)