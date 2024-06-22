import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Character previousChar = null;
        
        // 1. 닫는 기호는 +1
        // 2. () 기호는 스택 사이즈만큼 +
        for (char c : input) {
            if (c == '(') {
                stack.push(c);
            }

            else if (c == ')' && previousChar == '(') {
                stack.pop();
                count += stack.size();
            }

            else if (c == ')' && previousChar != '(') {
                count += 1;
                stack.pop();
            }

            previousChar = c;
        }

        System.out.println(count);
    }
}

