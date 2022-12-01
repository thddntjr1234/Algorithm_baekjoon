import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /*
         * ( 일땐 cnt++ )일땐 cnt--이고
         * 올바른 VPS이려면 (로 시작해서 )로 닫혀야 하므로 cnt 결과가 0이면서 중간에 cnt가 음수로 되지 않아야 한다.
         */
        for (int i=0; i<T; i++) {
            String str = br.readLine();
            int cnt = 0;
            for (int j=0; j<str.length(); j++) {
                if(str.charAt(j) == '(') cnt++;
                else cnt--;

                if(cnt < 0) break;
            }
            
            if(cnt == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}