array = [7, 4, 5, 1, 3]

for i in range(len(array), 0, -1):
    for j in range(0, i - 1):
        if array[j] > array[j + 1]:
            array[j], array[j + 1] = array[j + 1], array[j]
