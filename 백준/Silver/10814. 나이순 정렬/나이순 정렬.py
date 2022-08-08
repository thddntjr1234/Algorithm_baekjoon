import sys
N = int(input())
informs = [list(sys.stdin.readline().split()) for _ in range(N)]

informs.sort(key=lambda x:(int(x[0])))
for i in informs:
    print(i[0], i[1])