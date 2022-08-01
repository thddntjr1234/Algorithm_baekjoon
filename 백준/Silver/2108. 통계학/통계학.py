import sys

def calc(N, numList):
    numList.sort()
    
    x = int(sum(numList))
    if x >= 0:
        print(int(x / N + 0.5))
    else:
        print(int(x / N - 0.5))
    print(numList[N//2])
    
    maxCount = 1
    count = 1
    numDict = {}
    maxCountNumbers = []
    for i in range(1, N):
        if numList[i] == numList[i-1]:
            count += 1
            if i == N-1 and count >= maxCount:
                numDict[numList[i-1]] = count
                maxCount = count
        else:
            if count > maxCount:
                maxCount = count
            numDict[numList[i-1]] = count
            count = 1
    if N == 1:
        maxCountNumbers.append(numList[0])
        
    for j in numDict:
        if maxCount == numDict[j]:
            maxCountNumbers.append(j)
            
    maxCountNumbers.sort
    if len(maxCountNumbers) > 1:
        print(maxCountNumbers[1])
    else:
        print(maxCountNumbers[0])
        
    print(numList[N-1] - numList[0])
    
N = int(sys.stdin.readline())
numList = [int(input()) for _ in range(N)]
calc(N, numList)

