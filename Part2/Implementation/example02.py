'''

시각
정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오. 예를 들어 1을 입력했을 때
다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각이다.

- 00시 00분 03초
- 00시 13분 30초

반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안되는 시각이다.
- 00시 02분 55초
- 01시 27분 45초

입력 조건
1.첫째 줄에 정수 N이 입력된다. (0 <= N <= 23)

출력 조건
1.00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력한다.

완전 탐색(Brute Forcing) 유형
- 가능한 경우의 수를 모두 검사해보는 탐색 방법, 일반적으로 완전 탐색 알고리즘은 비효율적인 시간 복잡도를 가지고 있으므로 데이터 개수가 큰 경우에 정상적으로 동작하지 않는다.
- 따라서 탐색해야 할 데이터의 개수가 100만 개 이하일 때 사용하면 적절하다.
'''

N = int(input())

count = 0

finish_time_h, finish_time_m, finish_time_s = N, 59, 59

start_time_h, start_time_m, start_time_s = 0, 0, 0

for i in range(finish_time_h + 1):
    for j in range(finish_time_m + 1):
        for k in range(finish_time_s + 1):
            start_time_s += 1
            if start_time_s == 60:
                start_time_m += 1
                start_time_s = 0
            if start_time_m == 60:
                start_time_h += 1
                start_time_m = 0

            if (start_time_h > N):
                break

            print("h : ", start_time_h, "m : ", start_time_m, "s : ",start_time_s)

            if('3' in str(start_time_h) + str(start_time_m) + str(start_time_s)):
                count += 1

print(count)