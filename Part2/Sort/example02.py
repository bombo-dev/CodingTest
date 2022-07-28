'''
성적이 낮은 순서로 학생 출력하기

N명의 학생 정보가 있다. 학생 정보는 학생의 이름과 학생의 성적으로 구분된다. 각 학생의 이름과 성적 정보가 주어졌을 때 성적이 낮은 순서대로 학생의 이름을
출력하는 프로그램을 작성하시오.

입력조건
1. 첫 번째 줄에 학생의 수 N이 입력된다. ( 1 <= N <= 100,000 )
2. 두 번째 줄부터 N + 1번째 줄에는 학생의 이름을 나타내는 문자열 A와 학새으이 성적을 나타내는 정수 B가 공백으로 구분되어 입력된다.
단, 문자열 A의 길이와 학생의 성적은 100 이하의 자연수이다.
'''

N = int(input())
data = []

for _ in range(N):
    data.append(tuple(input().split()))

def setting(data):
    return int(data[1])

data = sorted(data, key = setting)

for i in range(len(data)):
    print(data[i][0], end = ' ')



