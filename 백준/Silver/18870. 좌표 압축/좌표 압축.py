N = int(input())
points = list(map(int, input().split()))
#중복 제거하고 정렬한 새로운 리스트 생성
temp_points = sorted(list(set(points)))

# 딕셔너리의 key값을 temp_points[i]의 값으로 만들고, i값을 value로 사용한다( O(1) )
result = {temp_points[i] : i for i in range(len(temp_points))}
for i in points:
    print(result[i], end = ' ')