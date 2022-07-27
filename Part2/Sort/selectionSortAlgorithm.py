# 선택 정렬 알고리즘 구현 예시

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_array_index = i
    for j in range(i + 1,len(array)):
        if array[min_array_index] > array[j]:
            min_array_index = j
    array[i], array[min_array_index] = array[min_array_index], array[i]

print(array)