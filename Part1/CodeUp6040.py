# [기초-산술연산] 정수 2개 입력받아 나눈 몫 계산하기
# n1 / n2 = 소수 자릿수 까지 표시 , n1 // n2 = 몫만 표시

a, b = map(int, input().split())
print(a // b)