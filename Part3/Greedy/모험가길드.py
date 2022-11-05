N = int(input())
fear = list(map(int, input().split()))

count = 0
result = 0
fear = sorted(fear)

for i in fear:
    count += 1
    if count >= i:
        result += 1
        count = 0

print(result)

# test_case [3, 1, 1, 1, 1]
# test_case [3, 2, 1, 1, 1]
# test_case [2, 2, 1, 1, 1]
# test_case [2, 2, 2, 2, 1]