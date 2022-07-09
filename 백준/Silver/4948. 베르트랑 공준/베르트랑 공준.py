while True:
    n = int(input())
    if n == 0:
        break
    
    arr = [False, False] + [True] * (2 * n-1)
    primes = []
    
    for i in range(2, len(arr)):
        if arr[i]:
            if i > n and i <= 2 * n:
                primes.append(i)
            for j in range (2 * i, len(arr), i):
                arr[j] = False
    
    print(len(primes))
    
