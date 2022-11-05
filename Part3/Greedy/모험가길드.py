N = int(input())
fear = list(map(int, input().split()))

count = 0
result = 0
fear = sorted(fear) # 공포도 오름 차순 정렬

for i in fear:
    count += 1
    if count >= i: # count가 현재 그룹원의 공포도보다 크거나 같은 경우
        result += 1 # 그룹에 추가
        count = 0

print(result)

# test_case [3, 1, 1, 1, 1]
# test_case [3, 2, 1, 1, 1]
# test_case [2, 2, 1, 1, 1]
# test_case [2, 2, 2, 2, 1]