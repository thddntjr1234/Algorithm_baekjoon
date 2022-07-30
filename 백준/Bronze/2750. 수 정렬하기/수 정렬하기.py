def AccendingSort(numList):
    for end in range(1, len(numList)):
        temp = numList[end]
        for i in range(end-1, -1, -1):
            if numList[i] < numList[end]:
                numList.remove(temp)
                numList.insert(i+1, temp)
                break
            elif i == 0:
                numList.remove(temp)
                numList.insert(0, temp)
    for j in range(len(numList)):
        print(numList[j])
N = int(input())
numList = [int(input()) for i in range(N)]
AccendingSort(numList)