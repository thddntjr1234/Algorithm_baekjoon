import sys
def AccendingSort(numList):
    numList.sort()
    for i in range(len(numList)):
        print(numList[i])

N = int(sys.stdin.readline())
numList = [int(input()) for _ in range(N)]
AccendingSort(numList)