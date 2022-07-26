# 재귀로 M, N의 최대공약수 구하기 (유클리드 호제법)
# M > N
def euclidean(x, y):
    if(x > y and x % y != 0):
        x %= y
        euclidean(y, x)
    else:
        print(y)

euclidean(192, 162)