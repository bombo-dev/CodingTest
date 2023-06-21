array = [7, 4, 5, 1, 3]

for i in range(len(array), -1):
    for j in range(0, i):
        if array[j] > array[j + 1]:
            array[j], array[j + 1] = array[j + 1], array[j]

print(array)