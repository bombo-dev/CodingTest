from itertools import combinations

n = int(input())

a = list(map(int, input().split()))
a.sort()

result = 1
sum_list = []


for i in range(1, len(a) + 1):
    combinations_list = list(combinations(a, i))
    for sum_data in combinations_list:
        print("i 번째 sum_data list : ", sum_data)
        if sum(sum_data) not in sum_list:
            sum_list.append(sum(sum_data))

sum_list.sort()

for i in range(len(sum_list)):
    if sum_list[i + 1] - sum_list[i] > 1:
        result = sum_list[i] + 1
        break

print(sum_list)
print(result)

# 이 때의 시간 복잡도 : O(n^2) + O(n) = O(n^2)
# 조합을 이용 하면 될 듯?
# 내부에서 발생할 수 있는 모든 조합의 합
# 리스트 내부에서 발생할 수 있는 모든 합을 어떻게 구하지?
# 1 1 2 3 9
# (1, 1), (1, 2), (1, 3), (1, 9)

# (1, 1, 2), (1, 1, 3), (1, 1, 9)
# (1, 2, 3), (1, 2, 9)
# (1, 3, 9)

# (1, 1, 2, 3), (1, 1, 2, 9)
# (1, 1, 3, 9)

# (1, 1, 2, 3, 9)