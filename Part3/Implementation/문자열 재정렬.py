# 모든 알파벳은 이어서 출력하고, 그 뒤에 모든 숫자를 더한 값을 이어서 출력한다

a = input()
left_list = []
right_side = []


index = 0

for i in range(len(a)):
    if ord(a[i]) < 65:
        right_side.append(int(a[i]))
    else:
        left_list.append(a[i])

left_list.sort()

left_side = ""
for data in left_list:
    left_side += data

right_sum = sum(right_side)

result = left_side + str(right_sum)

print(result)
