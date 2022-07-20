# [기초-종합] 언제까지 더해야 할까?

a = int(input())
sum = 0
count = 0


for i in range(1000 + 1):
    sum += i
    count = i

    if(sum >= a):
        break
print(count)
