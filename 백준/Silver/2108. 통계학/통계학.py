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
    for j in range(1, N+1):
        numDict[j] = []

    for i in range(1, N):
        if numList[i] == numList[i-1]:
            count += 1
        else:
            if count > maxCount:
                maxCount = count
            numDict[count].append(numList[i-1]) 
            count = 1
        if i == N-1:
            numDict[count].append(numList[i])
            if count > maxCount:
                maxCount = count
        
    if N == 1:
        numDict[1].append(numList[0])
            
    numDict[maxCount].sort()
    if len(numDict[maxCount]) > 1:
        print(numDict[maxCount][1])
    else:
        print(numDict[maxCount][0])
        
    print(numList[N-1] - numList[0])
    
N = int(sys.stdin.readline())
numList = [int(input()) for _ in range(N)]
calc(N, numList)

