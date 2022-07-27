# [알고리즘 노트]

## 1. 팁

### 1. 적은 수의 값을 공백으로 구분하여 입력받기

```python
# map(적용할 함수, iterator객체)
# input().split() => 리스트로 리턴

n, m, k = map(int, input().split())
```

### 2. 많은 수의 값을 공백으로 구분하여 입력받기
```python
data = list(map(int, input().split)))
```

### 3. 영문자를 10진수로 변환하기

```python
# ord = ordinal position, Unicode Character position

a = ord(input())
print(a)
```

### 4. 수를 소숫점 이하 n 자리 까지 반환
```python
a = float(input())
# print(format(a, ".nf"))
```

### 5. 10진수 ->16진수, 8진수 포맷팅
```python
a = int(input())
print('%x' %a) # if a = 15 , f
print('%X' %a) # if a = 15 , F
print('%o' %a) # if a = 10 , 12
```

### 6. 대부분의 코딩테스트에서의 파이썬의 메모리 제한
- 시간 제한이 1초이고, 데이터의 개수가 100만 개인 문제
- O(NlogN) 이내의 알고리즘을 이용하여 문제를 풀어야 한다. == 약 20,000,000
- 즉, 2000만 번 이하의 수행을 하도록 한다.

### 7. 방향을 설정해서 이동하는 문제 유형
- dx, dy라는 별도의 리스트를 만들어 방향을 정하는 것이 효과적이다.
```python
# 북, 동, 남, 서
direction = [0, 1, 2, 3]

# 북, 동, 남, 서
dx = [-1, 0, 1 ,0]
dy = [0, 1, 0, -1]
```

### 8. 그래프를 인접 행렬 방식으로 처리할 때 데이터 초기화 방식
```python
INF = 999999999

graph = [
  [0, 7, 5],
  [7, 0, INF],
  [5, INF, 0]
]
```

### 9. 그래프를 인접 리스트 방식으로 처리할 때 데이터 초기화 방식
```python

graph = [[] for _ in range(3)]

graph[0].append((1, 7))
graph[0].append((2, 5))

graph[1].append((0, 7))
graph[2].append((0, 5))
```

### 10. 많은 수의 값을 공백 구분없이 입력받기
```python
data = list(map(int, input()))
ex)12345678
print(data)
# [1, 2, 3, 4, 5, 6, 7, 8]
```

### 11. 리스트와 리스트의 합
```python
list1 = [1, 2]
list2 = [3, 4]

print(list1 + list2)
# [1, 2, 3, 4]
print([1] + [4])
# [1, 4]
```
### 12. 정렬 라이브러리에서 key를 활용한 소스코드
```python

array = [('바나나', 2), ('사과', 5), ('당근', 3)]

def setting(data):
  return data[1]
  
 result = sorted(array, key=setting)
 print(result)

# [('바나나', 2), ('당근', 3), ('사과', 5)]
```
---

## 2. 오답노트

### 1. 정수형 이어서 출력
```python

a, b = map(int, input().split())
print(a, b, sep='')
# 만약 a가 000312 b가 1234567이면 a의 000이 잘리고 3121234567로 출력이 된다.
# 따라서 2개를 합치고 정수형으로 만들고 싶으면 문자형으로 입력받고 c = a + b c = int(c) 로 형변환 해준다.
```

