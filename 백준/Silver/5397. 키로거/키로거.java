import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            List<Character> passwd = new LinkedList<>();
            ListIterator<Character> iter = passwd.listIterator();

            for (char instruction : input){
                switch (instruction) {
                    case '<':
                        if (iter.hasPrevious()) iter.previous();
                        break;
                    case '>':
                        if (iter.hasNext()) iter.next();
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(instruction);
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
