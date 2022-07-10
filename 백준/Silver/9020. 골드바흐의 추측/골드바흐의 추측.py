num = 10000
arr = [False, False] + [True] * (num-1)

for i in range(2, num+1):
    if arr[i]:
        for j in range(i*2, num+1, i):
            arr[j] = False
            

cycle = int(input())
count = 0
while count < cycle:
    count += 1
    n = int(input())
    a, b = n//2, n//2
    
    for i in range(n//2):
        if arr[a] and arr[b]:
            print(a, b)
            break
        else:
            a -= 1
            b += 1
