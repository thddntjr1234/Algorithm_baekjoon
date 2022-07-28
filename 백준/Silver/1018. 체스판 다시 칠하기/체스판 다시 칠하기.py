def Repainting(M, N, board):
    goalPaint_W = ['WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW']
    goalPaint_B = ['BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB','BWBWBWBW','WBWBWBWB']
    countList = list()
    for i in range(N-7):
        for j in range(M-7):
            count_W = 0
            count_B = 0
            for k in range(i, i+8):    
                for l in range(j, j+8):
                    if board[k][l] != goalPaint_W[k-i][l-j]:
                        count_W += 1
                    elif board[k][l] != goalPaint_B[k-i][l-j]:
                        count_B += 1
            countList.append(count_W)
            countList.append(count_B)
    return min(countList)

N, M = map(int, input().split())
board = list([input() for _ in range(N)])
print(Repainting(M, N, board))