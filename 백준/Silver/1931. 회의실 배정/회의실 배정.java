import java.util.*;
import java.io.*;

public class Main {
    /*
     * 기본적인 그리디 문제로 거스름돈 계산에서는 가장 큰 동전부터 구했지만 이 곳은 종료시간이 적은 순서대로 해야 가장 많은 회의를 가질 수 있게 된다.
     * 따라서 종료시간-시작시간 순서대로 정렬하기 위해 2차원 배열 정렬을 하고 이후 반복문을 통해서 그리디를 수행하면 된다.
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> { // Lambda 사용한 종료시간 기준 2차원 배열 정렬
            // 종료시간이 같은 경우 시작시간을 오름차순으로 정렬되게 해야 한다
            // ex) 1,3 8,8 4,8로 정렬되게 된다면 cnt가 3이 아닌 2가 됨
            if(o1[1] == o2[1]) { 
                return o1[0] - o2[0];   
            }
            return o1[1] - o2[1]; // 비교할 2차원 배열 o1, o2의 2번째 값에 대한 비교
        });

        int cnt = 0, end = 0; // 최대 회의실 개수, 종료시간
        for (int i=0; i<N; i++) {
            if (arr[i][0] >= end) { // 시작 시간이 이전 회의 종료 시간보다 같거나 큰 경우
                end = arr[i][1]; // 해당 회의가 회의실을 사용한 것으로 하고
                cnt++; // 카운트를 1 증가시킨다
            }
        }

        System.out.println(cnt);
    }
}