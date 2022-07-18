
# 1e9 = 10억 지수표시형

# ----------------------- 리스트 ------------------------------
# -------------------------------------------------------------

# 크기가 N이고, 모든 값이 0인 1차원 리스트 초기화
n = 10
list_init = [0] * n

# 리스트 컴프리헨션
# 1. 1 ~ 20까지 홀수만 포함하는 리스트 생성
list_init = [i for i in range(1, 20) if i % 2 == 1]

# 2. 크기가 N * M 인 2차원 리스트 초기화
N = 3
M = 4
list_init = [[0] * M for _ in range(N)]

# 리스트 관련 기타 메소드
# 1. append(), 변수명.append(), 리스트에 원소를 하나 삽입할 떄 사용 O(1) **
# 2. sort(), 변수명.sort(reverse = False), 기본 정렬 기능 O(NlogN)
# 3. reverse(), 변수명.reverse() 리스트의 원소와 순서를 모두 뒤집어 놓는다. O(N)
# 4. insert(), 변수명.insert(삽입할 위치 인덱스, 값) 특정한 인덱스 위치에 원소를 삽입할 때 사용한다. O(N) **
# 5. count(), 변수명.count(특정 값) 리스트에서 특정한 값을 가지는 데이터의 개수를 셀 때 사용한다. O(N)
# 6. remove(), 변수명.remove(특정 값) 특정한 값을 갖는 원소를 제거하는데, 값을 가진 원소가 여러개면 하나만 제거 O(N) **


# 3. 특정한 값을 가진 리스트에서 중복된 원소 제거
remove = [3, 5]
list_init = [1, 2, 2, 3, 4, 5, 6, 3, 5]

list_init = [i for i in list_init if i not in remove]

# ----------------------- 문자열 ------------------------------
# -------------------------------------------------------------

# 1. 특수문자 출력 \(이스케이프 문자)뒤에 작성
a = "Hello \"name\""

# 2. 문자열 연산 가능 +, *, slicing

# ----------------------- 튜플 ------------------------------
# -----------------------------------------------------------

# 1. 튜플은 한 번 선언된 값을 변경할 수 없다.
# 2. 리스트는 대괄호[]를 이용하지만, 튜플은 () 소괄호를 이용한다.
# 따라서 튜플 자료형은 그래프 알고리즘을 구현할 때 자주 사용된다. (다익스트라에서 사용하는 우선순위 큐 등)

tuple = (1, 2, 3, 4)

# ----------------------- 딕셔너리(맵) ------------------------
# -------------------------------------------------------------

# 1. 파이썬의 사전 자료형은 내부적으로 해시테이블을 이용한다. 따라서 검색 or 수정의 시간복잡도는 O(1) 이다.

data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['수박'] = 'WaterMellon'

# 2. 리스트, 사전, 튜플에 특정한 원소가 있는지 확인

# - 1. 리스트
list_init = [1, 2, 3, 4, 5]
# if 1 in list_init:
#     print("데이터가 존재합니다.")

# - 2. 튜플
tuple = (1, 2, 3, 4, 5)
# if 1 in tuple:
#     print("데이터가 존재합니다.")

# - 3. 딕셔너리
dict_init = dict()
dict_init['사과'] = 'Apple'
dict_init['바나나'] = 'Banana'
dict_init['파인애플'] = 'Pineapple'

# if '사과' in dict_init:
#     print("데이터가 존재합니다.")

# 3. 사전 자료형 관련 함수

# keys() : 키 데이터만 뽑아서 리스트로 이용할 때 사용
# values() : 값 데이터만 뽑아서 리스트로 이용할 때 사용

key_list = dict_init.keys()
# dict_keys(['사과', '바나나', '파인애플'])
value_list = dict_init.values()
# dict_values(['Apple', 'Banana', 'Pineapple'])

# for key in key_list:
#     print(dict_init[key])

# Apple
# Banana
# Pineapple

# ----------------------- 집합(set) ------------------------
# ----------------------------------------------------------

# 1. 중복을 허용하지 않는다.
# 2. 순서가 없다.
# 3. 특정 원소가 존재하는지 검사하는 연산의 시간 복잡도 O(1)

# 집합 자료형의 선언
# 1.
setinit = set([1, 1, 2, 3, 4, 5])

# 2.
setinit = {1, 1, 2, 3, 4, 5, 6}

# 집합 자료형의 연산
# - 1. 합집합
set1 = set([1, 1, 2, 3, 4])
set2 = set([1, 3, 5, 7, 9])

# print(set1 | set2)

# - 2. 교집합
# print(set1 & set2)

# - 3. 차집합
# print(set1 - set2)

# 집합 자료형 관련 함수
# - 1. add() 하나의 값을 추가
# set_init.add(10)
# - 2. update() 여러개의 값을 추가
# set_init.update([3, 4])
# - 3. remove() 특정한 값을 갖는 원소 삭제
# set_init.remove(3)

# ----------------------- 조건문 ---------------------------
# ----------------------------------------------------------

# 1. 파이썬 조건문 논리 연산자
# - 1. AND && if X > 0 AND X < 20 --> if 0 < X < 20 가능
# - 2. OR ||
# - 3. NOT !

# 2. 조건 표현신
score = 85
result = "Success" if score >= 80 else "Fail"

# ----------------------- 반복문 ---------------------------
# ----------------------------------------------------------

# 기존 알고 있는 것과 동일하다.

# ----------------------- 함수 -----------------------------
# ----------------------------------------------------------

# 1. 파이썬 함수에서 매개변수나 return 값이 존재하지 않을 수 있다.
# 2. 파이썬의 인자를 직접 전달 해줄 수 있다. 이때, 매개변수의 순서가 달라도 상관없다.
def add(a, b):
    print("a : ", a)
    print("b : ", b)

# add(b = 7, a = 3)

# 3. global 키워드로 전역변수에 접근할 수 있다.
a = 0

def func():
    global a
    a += 1

# 4. lambda 표현식을 사용할 수 있r다.

# print((lambda a, b : a + b)(3, 7))

# ----------------------- 입출력 ---------------------------
# ----------------------------------------------------------

# 1. 데이터를 입력받을 때는 input()을 이용한다. input()은 한 줄의 문자열을 입력 받도록 해준다.

# 2. 여러 개의 데이터를 입력받을 때 데이터가 공백으로 구분되는 경우
# - 1. 데이터의 개수 입력
# n = int(input())
# - 2. 각 데이터를 공백으로 구분하여 입력
# data = list(map(int, input().split()))

# 3. 여러 개의 데이터를 공백을 기준으로 구분하여 적은 수의 데이터 입력
# n, m, k = map(list(int, input().split()))

# 4. 입력의 개수가 많을 경우
import sys
# data = sys.stdin.readline().rstrip()

# 5. 문자열, 정수 동시 출력시
answer = 8

# print("정답은 " + str(answer) + "입니다.")

# ----------------------- 표준 라이브러리 ---------------------------
# -------------------------------------------------------------------

# 1. 내장함수
# - print(), input()과 같은 기본 입출력 기능부터 sorted()와 같은 정렬 기능을 포함하고 있는 기본 내장 라이브러리
# 2. itertools
# - 파이썬에서 반복되는 형태의 데이터를 처리하는 기능을 제공하는 라이브러리, 순열과 조합 라이브러리를 제공
# 3. heapq
# - 힙(Heap) 기능을 제공하는 라이브러리이다. 우선순위 큐 기능을 구현하기 위해 사용
# 4. bisect
# - 이진 탐색(Binary Search) 기능을 제공하는 라이브러리 이다.
# 5. collections
# - 덱(deque), 카운터(Counter) 등의 유용한 자료구조를 포함하고 있는 라이브러리이다.
# 6. math
# - 필수적인 수학적 기능을 제공하는 라이브러리이다. 팩토리얼, 제곱근, 최대공약수(GCD), 삼각함수, 파이와 같은 상수를 포함하고 있다.



# 내장함수
# - 1. sum()
# iterable 객체(list, dict, tuple 등)가 입력으로 주어졌을 때, 원소의 합을 반환
list_init = [1, 2, 3]
result = sum(list_init)

# - 2. min()
# 파라미터가 2개 이상 들어왔을 때 가장 작은 값을 반환
result = min(3, 7, 2, 4)
result = min(list_init)

# - 3. max()
# 파라미터가 2개 이상 들어왔을 때 가장 큰 값을 반환
result = max(3, 7, 2, 4)
result = max(list_init)

# - 4. eval()
# 수학 수식이 문자열 형태로 들어오면 해당 수식을 계산한 결과를 반환
result = eval("(3 + 5) * 7")

# - 5. sorted()
# iterable 객체가 들어왔을 때, 정렬된 결과를 반환. key 속성으로 정렬 기준을 명시할 수 있다.

result = sorted([('홍길동', 35), ('이순신', 75), ('아무개', 50)], key = lambda x: x[1])


# itertools
# - 1. permutations
# iterable 객체에서 r개의 데이터를 뽑아 일렬로 나열하는 모든 경우(순열)를 계산

from itertools import permutations

data = ['A', 'B', 'C']
result = list(permutations(data, 3))

# - 2. combination
# iterable 객체에서 r개의 데이터를 뽑아 순서를 고려하지 않고 나열하는 모든 경우(조합)를 계산

from itertools import combinations
result = list(combinations(data, 2))

# - 3. product
# iterable 객체에서 r개의 데이터를 뽑아 일렬로 나열하는 모든 경우(순열)를 계산하고, 원소를 중복하여 뽑음

from itertools import product

result = list(product(data, repeat = 2))

# - 4. combinations_with_replacement
# iterable 객체에서 r개의 데이터를 뽑아 순서를 고려하지 않고 나열하는 모든 경우(조합)를 계산, 원소를 중복하여 뽑음
from itertools import combinations_with_replacement

result = list(combinations_with_replacement(data, 2))

# heapq
# 1. 다익스트라 최단 경로 알고리즘을 포함해 다양한 알고리즘에서 우선순위 큐 기능을 구현하고자 할 때 사용
# 2. 파이썬의 힙은 최소 힙으로 구성되어 있어 O(NlogN)에 오름차순 정렬이 완료된다.
# 3. 원소를 삽입할 때는 heapq.heappush() 원소를 꺼낼때는 heapq.heappop() 메서드를 이용

import heapq

def heapsort(iterable):
    h = []
    result = []
    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h, value)

    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for i in range(len(h)):
        result.append(heapq.heappop(h))

    return result

result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])

# 파이썬에서는 최대 힙을 제공하지 않는다. 따라서 최대 힙을 구현할 때는 원소의 부호를 임시로 변경 후에 다시 꺼낼 때 변경하여 빼낸다.


# bisect

# 1. 정렬된 배열에서 특정한 원소를 찾아야 할 때 매우 효과적으로 사용된다.
# 2. 주로 bisect_left(), bisect_right() 함수가 가장 중요하게 사용되고, 이 두 함수는 시간 복잡도 O(logN) 이다.
# - 1. bisect_left(a, x) : 정렬된 순서를 유지하면서 리스트 a에 데이터 x를 삽입할 가장 왼쪽 인덱스를 찾는 메서드
# - 1. bisect_right(a, x) : 정렬된 순서를 유지하면서 리스트 a에 데이터 x를 삽입할 가장 오른쪽 인덱스를 찾는 메서드

from bisect import bisect_left, bisect_right

a = [1, 2, 4, 4, 8]
x = 4
y = -1

# print(bisect_left(a, x), bisect_right(a, x))
# 값이 없으면 0을 출력한다.
# print(bisect_left(a, y), bisect_right(a, y))

# 정렬된 리스트에서 값이 특정 범위에 속하는 원소의 개수

def count_by_range(a, left_value, right_value):

    left = bisect_left(a, left_value)
    right = bisect_right(a, right_value)

    return right - left

a = [3, 1, 2, 7, 4, 7, 4, 5, 2, 1, 9, 8]
a.sort()

# print(count_by_range(a, 1, 4))

# collections

# 1. deque
# deque는 스택이나 큐의 기능을 모두 포함하고 있어 스택 혹은 큐 자료구조의 대응으로 사용될 수 있다.
# - 1. deque.popleft()
# 첫번째 원소를 제거
# - 2. deque.pop()
# 마지막 원소를 제거
# - 3. deque.appendleft()
# 맨 앞에 원소 추가
# - 4. deque.append()
# 맨 뒤에 원소 추가

# 2. Counter
# iterable 객체가 주어졌을 때, 해당 객체 내부의 원소가 몇 번씩 등장했는지를 알려준다.

from collections import Counter

counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])
# print(counter['blue'])
