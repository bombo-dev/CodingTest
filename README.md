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

---

## 2. 오답노트

### 1. 정수형 이어서 출력
```python

a, b = map(int, input().split())
print(a, b, sep='')
# 만약 a가 000312 b가 1234567이면 a의 000이 잘리고 3121234567로 출력이 된다.
# 따라서 2개를 합치고 정수형으로 만들고 싶으면 문자형으로 입력받고 c = a + b c = int(c) 로 형변환 해준다.
```

