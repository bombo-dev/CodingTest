'''
M의 크기가 100억 이상으로 커질 경우 풀이
반복해서 더 해지는 수열의 길이 = K + 1
M / (K + 1) 이 수열이 반복되는 횟수, (M / (K + 1)) * K 가 가장 큰 수가 등장하는 횟수, 그러나 나누어 떨어지지 않는 경우 M % (K + 1) 을 더해주어야 한다.
'''

n, m, k = map(int, input().split())

list = list(map(int, input().split()))
list.sort()

first = list[n-1]
second = list[n-2]

first_count = int(m / (k + 1)) * k + m % (k + 1)
second_count = int(m / (k + 1))

result = (first * first_count) + (second * second_count)

print(result)
