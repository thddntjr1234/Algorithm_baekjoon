N = int(input())
if N != 0:
    for i in range(1, N):
        N *= i
else:
    N = 1

print(N)

