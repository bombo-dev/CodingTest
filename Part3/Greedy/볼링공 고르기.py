from itertools import combinations

n, m = map(int, input().split())

weight = list(map(int, input().split()))
bowling = []

# 볼링공의 번호 1번부터, 입력 된 공의 무게를 tuple에 넣어준다.
for i in range(1, n + 1):
    bowling.append((i, weight[i - 1]))

# 조합을 이용하여 모든 경우를 구하고
result_list = list(combinations(bowling, 2))
# 나온 경우의 수를 담는다.
result = len(result_list)

# 이때, 두 사람은 서로 무게가 다른 볼링공을 골라야하기 때문에, 조합에서 무게가 동일한 공들은 조합의 개수에서 빼준다.
for weight in result_list:
    if weight[0][1] == weight[1][1]:
        result -= 1
print(result)




