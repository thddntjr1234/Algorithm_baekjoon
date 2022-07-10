import sys
arr = [False, False] + [True] * (9999)

for i in range(2, 101):
    if arr[i]:
        for j in range(i*2, 10001, i):
            arr[j] = False
            

cycle = int(input())
for _ in range(cycle):
    n = int(sys.stdin.readline())
    a, b = n//2, n//2
    
    for i in range(n//2):
        if arr[a] and arr[b]:
            print(a, b)
            break
        a -= 1
        b += 1
