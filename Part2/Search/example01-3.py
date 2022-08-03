# 계수 정리를 이용한 부품 찾기 풀이

import sys

N = int(input())
store_components = list(map(int, sys.stdin.readline().rstrip().split()))

M = int(input())
customer_components = list(map(int, sys.stdin.readline().rstrip().split()))

count_array = [0] * (max(store_components) + 1) 

for i in store_components:
    count_array[i] = 1

for j in customer_components:
    if count_array[j] == 1:
        print("yes", end=' ')
    else:
        print("no", end=' ')