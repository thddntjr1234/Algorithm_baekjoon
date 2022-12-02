import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while (true) {
            String str = br.readLine();
            stack.clear();
            boolean check = true;

            if (str.charAt(0) == '.') break;

            for (int i=0; i<str.length(); i++) {
                char letter = str.charAt(i);
                if (letter == '(' || letter == '[') stack.push(letter);

                else if (letter == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        check = false;
                        break;
                    }
                    else stack.pop();
                }

                else if (letter == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        check = false;
                        break;
                    }
                    else stack.pop();
                }
            }

            if (!stack.isEmpty()) check = false;
            
            if (check) System.out.println("yes");
            else System.out.println("no");
        }
    }
}