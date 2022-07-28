# 계수 정렬을 이용한 풀이

n, k = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

count_a = [0] * (max(a) + 1)
count_b = [0] * (max(b) + 1)

result_a = []
result_b = []


for i in range(len(a)):
    count_a[a[i]] += 1
    count_b[b[i]] += 1


for i in range(len(count_a)):
    for j in range(count_a[i]):
        result_a.append(i)

for i in range(len(count_b) - 1, 0, -1):
    for j in range(count_b[i]):
        result_b.append(i)

for i in range(k):
    if(result_a[i] < result_b[i]):
        result_a[i], result_b[i] = result_b[i], result_a[i]
    else:
        break

print(result_a)
print(result_b)

print(sum(result_a))

