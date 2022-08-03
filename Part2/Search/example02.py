'''
떡볶이 떡 만들기

오늘 동빈이는 여행 가신 부모님을 대신해서 떡집 일을 하기로 했다. 오늘은 떡볶이 떡을 만드는 날이다. 동빈이네 떡볶이 떡은
재밌게도 떡볶이 떡의 길이가 일정하지 않다. 대신에 한 봉지 안에 들어가는 떡의 총 길이는 절단기로 잘라서 맞춰준다.

절단기에 높이(H)를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H 위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않는다.

예를 들어 높이가 19, 14, 10, 17cm인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면 자른 뒤 떡의 높이는 15, 14, 10, 15cm가 될 것이다.
잘린 떡의 길이는 차례대로 4, 0, 0, 2cm 이다. 손님은 6cm만큼의 길이를 가져간다.

손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.

입력 조건
1. 첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어진다. (1 <= N <= 1,000,000, 1 <= M <= 2,000,000,000)
2. 둘째 줄에는 떡의 개별 높이가 주어진다. 떡 높이의 총합은 항상 M 이상이므로, 손님은 필요한 양 만큼 떡을 사갈 수 있다. 높이는 10억보다
작거나 같은 양의 정수 또는 0이다.

출력 조건
1. 적어도 M만큼의 떡을 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
'''

import sys

def binary_search(array, min, max, target):

    # 이전에 설정한 높이
    pre_height = 0

    # 최소 길이가 최대 길이를 넘지 않을 때 까지
    while min <= max:
        # 자른 길이의 원소를 저장하는 배열 생성
        new_array = [0] * len(array)

        # 최소 길이와 최대 길이의 중간 값
        mid = (min + max) // 2

        # 새로운 배열에 자른 길이의 원소 저장
        for i in range(len(array)):
            if((array[i] // mid) == 0):
                new_array[i] = 0
            else:
                new_array[i] = array[i] % mid

        # 새로운 배열의 자른 원소의 합이 고객이 요청한 높이와 맞으면
        if sum(new_array) == target:
            return mid
            break
        # 고객이 요청한 높이보다 작으면
        elif sum(new_array) < target:
            max -= 1
        # 고객이 요청한 높이보다 크면
        else:
            min += 1

        # 새로운 배열의 합이 고객이 요청한 높이보다 작은데 전에 계산한 배열의 합이 고객이 요청한 합보다 컸으면
        if ((sum(new_array) < target) and (pre_height > target) and pre_height != 0):
            return mid
            break

        # 새로운 배열의 합이 고객이 요청한 높이보다 큰데 전에 계산한 배열의 합이 고객이 요청한 합보다 작았으면
        elif ((sum(new_array) > target) and (pre_height < target) and pre_height != 0):
            return mid
            break

        # 이번 배열의 합을 저장
        pre_height = sum(new_array)

# 떡의 개수 N, 고객이 요청한 높이 M 저장
N, M = map(int, sys.stdin.readline().rstrip().split())

# 떡의 개수 N 만큼 ricecake의 원소 지정
ricecake = list(map(int, sys.stdin.readline().rstrip().split()))

print(binary_search(ricecake, min(ricecake), max(ricecake), M))






