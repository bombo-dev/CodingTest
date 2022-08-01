# 이진 탐색 반복문 풀이

def binarySearch(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if array[mid] == target:
            return mid + 1
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

import sys

N = int(input())
store_components = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(input())
customer_componets = list(map(int, sys.stdin.readline().rstrip().split()))

for target in customer_componets:
    result = binarySearch(store_components, target, 0, len(store_components) - 1)

    if result != None:
        print("yes", end=' ')
    else:
        print("no", end=' ')
