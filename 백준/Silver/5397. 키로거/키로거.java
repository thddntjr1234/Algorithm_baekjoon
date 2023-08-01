import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            List<Character> passwd = new LinkedList<>();
            int cursor = 0;
            
            for (char instruction : input){
                switch (instruction) {
                    case '<':
                        if (cursor > 0) cursor--;
                        break;
                    case '>':
                        if (cursor < passwd.size()) cursor++;
                        break;
                    case '-':
                        if (cursor > 0 && passwd.size() > 0) {
                            passwd.remove(cursor-1);
                            cursor--;
                        }
                        break;
                    default:
                        passwd.add(cursor, instruction);
                        cursor++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character ch : passwd) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}
