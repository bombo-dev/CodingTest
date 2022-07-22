'''
왕실의 나이트
행복 왕국의 왕실 정원은 체스판과 같은 8 X 8 좌표 평면이다. 왕실 정원의 특정한 한 칸에 나이트가 서 있다. 나이트는 매우 충성스러운 신하로서 매일 무술을 연마한다.
나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다. 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.

    1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
    2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기

입력 조건
1. 첫째 줄에 8 X 8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다. 입력 문자는 a1처럼 열과 행으로 이뤄진다.
2. 첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력하시오.

'''

ptr = input()
count = 0

col = ptr[0]
row = int(ptr[1])

if(ord(col) + 2 <= ord('h') and row + 1 <= 8):
    count += 1
if(ord(col) + 2 <= ord('h') and row - 1 >= 1):
    count += 1
if(row + 2 <= 8 and ord(col) + 1 <= ord('h')):
    count += 1
if(row + 2 <= 8 and ord(col) - 1 >= ord('a')):
    count += 1
if(ord(col) - 2 >= ord('a') and row + 1 <= 8):
    count += 1
if(ord(col) - 2 >= ord('a') and row - 1 >= 1):
    count += 1
if(row - 2 >= 1 and ord(col) - 1 >= ord('a')):
    count += 1
if(row - 2 >= 1 and ord(col) + 1 <= ord('h')):
    count += 1

print(count, end="")
