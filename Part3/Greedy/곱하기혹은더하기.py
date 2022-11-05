S = input()

list = []
for i in range(len(S)):
    list.append(int(S[i]))

result = 0

for i in range(len(S)):
    if i == 0:
        result += list[i]
    else:
        if list[i - 1] <= 1 and list[i] <= 1:
            result += list[i]
        else:
            result *= list[i]

print(result)

# 0 일 때 만이 아닌 1일 때도 상정
