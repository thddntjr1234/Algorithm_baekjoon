def AccendingSort(numList):    
    for key in range(1, len(numList)):
        for j in range(key, 0, -1):
            if numList[j] < numList[j-1]:
                numList[j-1], numList[j] = numList[j], numList[j-1]        
    for i in range(len(numList)):
        print(numList[i])

N = int(input())
numList = [int(input()) for i in range(N)]
AccendingSort(numList)