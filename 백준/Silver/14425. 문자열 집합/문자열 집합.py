import sys
N, M = map(int, input().split())
# List Comprehension
initial = set([sys.stdin.readline().rstrip() for _ in range(N)])
check = [sys.stdin.readline().rstrip() for _ in range(M)]

# Set 집합 자료형에서는 리스트와 달리 in의 시간복잡도가 O(1)임(해쉬를 사용하기 때문에)
count = 0
for string in check:
    if string in initial:
        count += 1

print(count)