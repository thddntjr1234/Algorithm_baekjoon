import sys
def AccendingSort(numList):
    for i in range(10001):
        if numList[i] != 0:
            for j in range(numList[i]):
                sys.stdout.write(str(i) + '\n')

N = int(input())
numList = [0] * 10001
for i in range(N):
    x = int(sys.stdin.readline())
    numList[x] += 1
AccendingSort(numList)