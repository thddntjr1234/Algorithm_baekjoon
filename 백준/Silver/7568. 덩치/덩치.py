def CalculateRank(N, studentInfo):
    rank = list()
    for i in studentInfo:
        tempRank = 1
        for j in studentInfo:
            if i[0] < j[0] and i[1] < j[1]:
                tempRank += 1 
        rank.append(tempRank)
    return rank

N = int(input())
studentInfo = [list(map(int, input().split())) for i in range(N)]

print(*CalculateRank(N, studentInfo))