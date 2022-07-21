'''
큰 수의 법칙
여기서의 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙. 단, 배열의 특정한 인덱스(번호)에 해당하는
수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징이다.

예를 들어 순서대로 2, 4, 5, 4, 6으로 이루어진 배열이 있을 때 M이 8이고, K가 3이라고 가정하자. 이 경우 특정한 인덱스의 수가 연속해서 세 번 까지만 더해질 수 있으므로
큰 수의 법칙에 따른 결과는 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5인 46이 된다.
'''

n, m, k = map(int, input().split())

list = list(map(int, input().split()))

list.sort()
k_count = 0
total = 0
for i in range(m):
    if k_count == k:
        total += list[n-2]
        k_count = 0
        continue
    total += list[n-1]
    k_count += 1

print(total)