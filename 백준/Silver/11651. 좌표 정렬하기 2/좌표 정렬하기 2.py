import sys
N = int(input())
nums = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
nums.sort(key=lambda x:(x[1], x[0]))
for x, y in nums:
    print(x, y)