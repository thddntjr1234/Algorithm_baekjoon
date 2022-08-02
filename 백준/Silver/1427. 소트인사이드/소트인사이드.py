def DecendingSort(N):
    nums = [int(x) for x in str(N)]
    nums.sort(reverse=True)
    print(*nums, sep='')
    
N = int(input())
DecendingSort(N)    