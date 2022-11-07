food_times = [[3, 1, 2], [3, 1, 1, 1, 2, 4, 3]]
k = [5, 12]
answer = [1, 6]


def solution(food_times, k):
    answer = -1
    index = 0
    count = 0

    while count <= k:
        index = index % len(food_times)

        if len(food_times) == food_times.count(0):
            answer = -1
            return answer

        if food_times[index] > 0:
            food_times[index] -= 1
            index += 1
            count += 1
        else:
            index += 1

    answer = index
    return answer

for i in range(len(food_times)):
    if answer[i] == solution(food_times[i], k[i]):
        print("정답입니다.")
    else:
        print("오답입니다.")



