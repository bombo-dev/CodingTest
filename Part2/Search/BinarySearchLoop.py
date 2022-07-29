# 이진 탐색 반복문 구현

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        # 찾은 경우 중간점 인덱스 반환
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

n, target = map(int, input().split())

array = list(map(int, input().split()))

result = binary_search(array, target, 0, n - 1)

if result == None:
    print("찾고자 하는 원소가 없습니다.")
else:
    print(result + 1)