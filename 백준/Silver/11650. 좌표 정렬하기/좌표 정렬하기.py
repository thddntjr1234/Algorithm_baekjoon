import sys
N = int(input())       
nums = [list(map(int, sys.stdin.readline().split())) for x in range(N)]
nums.sort()
for x, y in nums:
    print(x, y)