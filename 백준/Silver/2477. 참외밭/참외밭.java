import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();// 1m^2에 생산되는 참외 개수
		
		int[][] map = new int[6][2];
		
		int width = 0; //가로
		int height = 0; //세로
		
		int width_index = 0; // 가로 최대값 인덱스
		int height_index = 0;// 세로 최대값 인덱스
		
		int width_max = 0; // 가로 최대값
		int height_max = 0; // 세로 최대값
		
		for(int i=0;i<6;i++) {
			map[i][0] = sc.nextInt(); //방향
			map[i][1] = sc.nextInt(); //길이
		}
		
		for(int i=0;i<6;i++) {
			//가로일 때 최대값과 인덱스 찾기
			if(map[i][0]==1 || map[i][0]==2) {
				if(width_max<map[i][1]) {
					width_max = map[i][1];
					width_index = i;
				}
			}
			
			//세로일 때 최대값과 인덱스 찾기
			else if(map[i][0]==3 || map[i][0]==4) {
				if(height_max<map[i][1]) {
					height_max = map[i][1];
					height_index = i;
				}
			}
		}
		int W = 0;
		int H = 0;
		
		if(width_index==0) W = Math.abs(map[5][1] - map[width_index+1][1]);
		else if(width_index==5) W = Math.abs(map[width_index-1][1] - map[0][1]);
		else W = Math.abs(map[width_index-1][1] - map[width_index+1][1]);
		
		if(height_index==0) H = Math.abs(map[5][1] - map[height_index+1][1]);
		else if(height_index==5) H = Math.abs(map[height_index-1][1] - map[0][1]);
		else H = Math.abs(map[height_index-1][1] - map[height_index+1][1]);
		
		int sub_square = W*H;
		System.out.println((width_max * height_max - sub_square)*K);
		
	}
}