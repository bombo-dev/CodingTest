# DP 테이블 공간 초기화, 메모이제이션은 탑 다운 방식에 국한된 용어이다.
d = [0] * 100

d[0] = 1
d[1] = 1

n = 99

# 피보나치 함수(Fibonacci Function) 반복문으로 구현(Bottom-Up 프로그래밍 방식)
for i in range(3, n + 1):
    d[i] = d[i - 1] + d[i - 2]

