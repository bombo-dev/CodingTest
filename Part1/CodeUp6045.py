# [기초-산술연산] 정수 3개 입력받아 합과 평균 출력하기

a, b, c = map(int, input().split())

d = a + b + c
print(d, format(d / 3, ".2f"))