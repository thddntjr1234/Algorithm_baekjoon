import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0, r1 = 0, r2 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            // 원의 사이즈도 같고, 좌표도 같은 경우 
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1); 
            }
            // 두 원의 반지름 합보다 중심 좌표 차이가 더 길 때(원이 서로 닿지 않고 떨어진 경우)
            // 원 안에 원이 있지만 내접하지 않을 때(큰 원의 반지름이 큰 원과 작은 원의 좌표차 + 작은 원의 반지름값보다 클 때)
            else if(distance > Math.pow(r1 + r2, 2) || distance < Math.pow(r2 - r1, 2)) {
                System.out.println(0);
            }

            // 두 원이 안에서 내접하거나(원의 반지름 차이만큼 중심 좌표가 차이난다면 원의 크기는 다르나 한 점에서 만남)
            // 외부에서 서로 접하는 경우(각 원의 반지름 합과 중심 좌표차이의 합이 같으면 원은 한 점에서 만나게 됨)
            else if(distance == Math.pow(r2 - r1, 2) || distance == Math.pow(r1 + r2, 2)) {
                System.out.println(1);
            }
            
            // 이외 케이스에서는 원이 두 점에서 만나게 된다.
            else System.out.println(2);
        }
    }
}