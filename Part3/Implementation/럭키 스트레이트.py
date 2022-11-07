# 점수 N 자릿수를 기준으로 반을 나누고 왼쪽의 각 자릿수의 합과 오른쪽의 각 자릿수의 합이 같으면 스킬 사용

N = input()

length = len(N)
length /= 2
length = int(length)
left_list = N[:length]
right_list = N[length:]

left = list(map(int, left_list))
right = list(map(int, right_list))

left = sum(left)
right = sum(right)

if left == right:
    print("LUCKY")
else:
    print("READY")

