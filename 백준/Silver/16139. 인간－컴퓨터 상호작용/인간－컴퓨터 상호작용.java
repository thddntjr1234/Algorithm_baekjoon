import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // println은 시간 초과가 발생한다
        String S = br.readLine();
        int[][] sum = new int[S.length()][26]; // 문자열 인덱스별로 인덱스에 해당하는 알파벳에 대한 누적합 배열
        int q = Integer.parseInt(br.readLine());

        // 누적합은 이전 값 + 자신의 값 식을 통해 수행되는데 for을 1부터 돌리려면 0에 이미 값이 들어있어야 1에 대한 누적합을 구할 수 있다.
        sum[0][S.charAt(0)-'a']++;

        // 입력한 문자열 s에 대해 누적합을 미리 구한다.
        for (int i=1; i<S.length(); i++) {
            for (int j=0; j<26; j++) {
                sum[i][j] += sum[i-1][j];
            }
            sum[i][S.charAt(i)-'a']++;
        }

        for (int i=0; i<q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alphabet = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int idx = alphabet-'a';
            
            // l이 0인 경우엔 이 부분구간에서 제외해야 할 다른 부분구간이 없으므로 그대로 r 인덱스 값을 출력
            if (l == 0) sb.append(sum[r][idx]).append('\n');

            // 0이 아닌 경우 제외해야 할 부분구간이 있으므로 제외하고 출력
            else sb.append(sum[r][idx] - sum[l-1][idx]).append('\n');
        }

        System.out.println(sb);
    }
}