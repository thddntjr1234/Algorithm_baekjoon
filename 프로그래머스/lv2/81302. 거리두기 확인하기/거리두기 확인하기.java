class Solution {
    
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        // String타입 배열 대기실을 별도의 2차원 Char배열의 대기실로 변환
        for (int i=0; i<places.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            
            for (int j=0; j<place.length; j++) {
                room[j] = place[j].toCharArray();
            } 
            
            // 각 대기실이 거리두기를 준수하는지 검사
            if (isValidRoom(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private boolean isValidRoom(char[][] room) {
        // 대기실의 전체 좌표를 순회하면서 P를 만나는 경우 거리두기 여부를 검사
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x <room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isValidDistance(room, x, y)) return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidDistance(char[][] room, int x, int y) {
        // P의 상하좌우에 다른 P 혹은 테이블이 있는지 검사
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            // 탐색할 다음 좌표 (nx, ny)가 유효한 좌표인지 확인
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            
            // 유효한 좌표에 대해 탐색
            switch (room[ny][nx]) {
                case 'P':
                   return false;
                case 'O':
                    // 이동해온 좌표를 제외하고 나머지 방향에 대해 탐색
                    if (isInvalidDistance(room, nx, ny, new int[]{x, y})) return false;
                    break;
            }
        }
        
        return true;
    }
    
    private boolean isInvalidDistance(char[][] room, int x, int y, int[] exclude) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            // exclude 좌표인 경우 continue
            if (nx == exclude[0] && ny == exclude[1]) continue;
            // 탐색할 다음 좌표 (nx, ny)가 유효한 좌표인지 확인
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            // 탐색할 좌표의 값이 P라면 거리두기가 지켜지지 않은 것이므로 true 반환
            if (room[ny][nx] == 'P') return true;            
        }
        return false;
    }
}