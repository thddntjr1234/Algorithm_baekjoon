N = int(input())
nums_N = list(map(int, input().split()))
M = int(input())
nums_M = list(map(int, input().split()))
# if num in List는 시간초과가 발생할 수 있으니
# 숫자를 리스트 인덱스로 사용하기 위해 2000만 크기의 배열 선언
card_list = [0] * 20000000

# 먼저 존재하는 수에 대해서 배열에 1을 대입
for i in nums_N:
    card_list[i+10000000] = 1
# 비교할 대상을 순회시키면서 인덱스의 값이 1이면 1, 0이면 0을 출력
for j in nums_M:
    if card_list[j+10000000]:
        print(1, end=' ')
    else:
        print(0, end=' ')