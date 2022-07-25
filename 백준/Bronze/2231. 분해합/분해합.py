def Decomposesum(N):
    result = 0
    minimum = N - len(str(N)) * 9
    if minimum <= 0:
        minimum = 1
        
    for i in range(minimum, N):
        eachSum = i
        for j in str(i):
            eachSum += int(j)
        if eachSum == N:
            result = i
            break
    return result        

N = int(input())
print(Decomposesum(N))