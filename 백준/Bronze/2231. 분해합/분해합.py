def Decomposesum(N):
    minTotal = N
    minimum = N - len(str(N)) * 9
    if minimum <= 0:
        minimum = 1
        
    for i in range(minimum, N):
        eachSum = i
        for j in str(i):
            eachSum += int(j)
        
        if eachSum == N and i < minTotal:
            minTotal = i
            
    if minTotal == N:
        return 0
    else:
        return minTotal

N = int(input())
print(Decomposesum(N))