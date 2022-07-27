array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

def QuickSort(array, start, end):

    if(start >= end):
        return

    pivot = start
    left = start
    right = end

    while left <= right:
        while left <= end and array[pivot] >= array[left]:
            left += 1
        while right > start and array[pivot] <= array[right]:
            right -= 1

        if (left >= right):
            array[pivot], array[right] = array[right], array[pivot]
        else:
            array[left], array[right] = array[right], array[left]

    QuickSort(array, start, right - 1)
    QuickSort(array, right + 1, end)

QuickSort(array, 0, len(array) - 1)

print(array)
