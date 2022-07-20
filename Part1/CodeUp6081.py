# [기초-종합] 16진수 구구단 출력하기


a = int(input(), 16)

for i in range(15):
    print('%X'%a,"*",'%X'%(i+1),"=","%X"%(a*(i+1)), sep="")
