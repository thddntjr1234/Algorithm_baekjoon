import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<Long[]> points = calIntersectionPoints(line);

        // 교점에서 각각 최대값과 최소값을 계산
        Long[] maxPoint = getMaxSize(points);
        Long[] minPoint = getMinSize(points);

        int xSize = (int) (maxPoint[0] - minPoint[0] + 1);
        int ySize = (int) (maxPoint[1] - minPoint[1] + 1);

        // 최대 크기의 배열 arr을 생성
        char[][] arr = new char[ySize][xSize];

        // arr의 값을 '.'로 초기화
        for (char[] row: arr) {
            Arrays.fill(row, '.');
        }

        // 그래프와 배열의 좌표 차이를 보정할 때 사용할 값
        int minX = minPoint[0].intValue();
        int maxY = maxPoint[1].intValue();

        for (Long[] point: points) {
            // 그래프상의 0, 0과 배열상의 0, 0은 다르기 때문에 이를 보정한다.
            int x = (int) (point[0] - minX);
            int y = (int) (maxY - point[1]);

            if (arr[y][x] == '.') {
                arr[y][x] = '*';
            }
        }

        String[] answer = new String[arr.length];
        int i = 0;
        for (char[] row: arr) {
            answer[i++] = String.valueOf(row);
        }
        return answer;
    }

    List<Long[]> calIntersectionPoints(int[][] line) {
        // 중복 좌표를 제거하기 위해서 HashSet을 사용
        List<Long[]> points = new LinkedList<>();

        // 교점을 구하는 메인 로직
        for (int[] mainLine : line) {
            long x1 = mainLine[0];
            long y1 = mainLine[1];
            long c1 = mainLine[2];

            for (int[] subLine : line) {
                // 강화 for문을 사용하기 때문에 같은 직선인 경우 continue
                if (mainLine.equals(subLine)) {
                    continue;
                }

                long x2 = subLine[0];
                long y2 = subLine[1];
                long c2 = subLine[2];

                // 교점 계산식
                double x = (double) (y1 * c2 - y2 * c1) / (x1 * y2 - x2 * y1);
                double y = (double) (x2 * c1 - x1 * c2) / (x1 * y2 - x2 * y1);

                // 정수여부 판별
                if (x % 1 == 0 && y % 1 == 0) points.add(new Long[]{(long) x, (long) y});
            }
        }
        return points;
    }

    Long[] getMaxSize(List<Long[]> points) {

        Long[] maxPoint = new Long[2];
        maxPoint[0] = Long.MIN_VALUE;
        maxPoint[1] = Long.MIN_VALUE;

        for (Long[] point: points) {
            if (maxPoint[0] < point[0]) maxPoint[0] = point[0];
            if (maxPoint[1] < point[1]) maxPoint[1] = point[1];
        }

        return maxPoint;
    }

    Long[] getMinSize(List<Long[]> points) {

        Long[] minPoint = new Long[2];
        minPoint[0] = Long.MAX_VALUE;
        minPoint[1] = Long.MAX_VALUE;

        for (Long[] point : points) {
            if (minPoint[0] > point[0]) minPoint[0] = point[0];
            if (minPoint[1] > point[1]) minPoint[1] = point[1];
        }

        return minPoint;
    }
}