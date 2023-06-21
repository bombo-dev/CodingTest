array = [5, 3, 8, 4, 9, 1, 6, 2, 7]


def quicksort(arr, start, end):
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end
    while left <= right:

        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right > start and array[right] >= array[pivot]:
            right -= 1

        if left > right:
            array[pivot], array[right] = array[right], array[pivot]
        else:
            array[left], array[right] = array[right], array[left]

        quicksort(array, start, right - 1)
        quicksort(array, right + 1, end)


quicksort(array, 0, len(array) - 1)
print(array)