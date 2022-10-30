import java.util.*;
import java.io.*;

public class Main {
    static int arr[];
    static int operator[];
    static int N, MAX = -1000000000, MIN = 1000000000;

    public static void dfs(int num, int index) {
        if (index == N) {
            MAX = Math.max(num, MAX);
            MIN = Math.min(num, MIN);
        }

        for (int i=0; i<4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                
                switch(i) {
                    case 0: dfs(num+arr[index], index+1); break;
                    case 1: dfs(num-arr[index], index+1); break;
                    case 2: dfs(num*arr[index], index+1); break;
                    case 3: dfs(num/arr[index], index+1); break;
                }

                operator[i]++;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }
}