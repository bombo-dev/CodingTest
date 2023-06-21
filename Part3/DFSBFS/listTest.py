list_test = []

n = int(input())

for i in range(n):
    list_test.append(list(map(int, input())))

print(list_test)
print(list_test[0][n - 1])