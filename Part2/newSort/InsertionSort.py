array = [8, 5, 6, 2, 4]

for i in range(1, len(array)):
    for j in range(i, 0, -1):
        print("present j ", j)
        if array[j] < array[j - 1]:
            array[j - 1], array[j] = array[j], array[j - 1]
        else:
            break