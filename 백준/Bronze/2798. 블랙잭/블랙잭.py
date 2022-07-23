def Blackjack(n, m, numList):
    total = 0
    for i in range(len(numList)):
        for j in range(i+1, len(numList)):
            for k in range(j+1, len(numList)):
                temporalSum = numList[i] + numList[j] + numList[k]
                if temporalSum <= m and temporalSum > total:
                    total = temporalSum
    print(total)

n, m = map(int, input().split())
numList = list(map(int, input().split()))

Blackjack(n, m, numList)
