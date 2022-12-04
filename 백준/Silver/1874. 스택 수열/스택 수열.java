import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] arr = new int[n+1]; // j가 n까지 증가하게 되므로 n+1만큼 선언
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 처음 peek()시 스택이 비어 있어 오류 방지와 j가 n까지 증가하게 되는 경우 비교 조건문이 참이 되므로 -1로 선언

        for (int i=0; i<n; i++) { // 목표 수열을 담는 배열
            arr[i] = sc.nextInt();
        }

        int i = 1, j = 0;
        while (i<=n+1) {
            int target = arr[j];

            if (stack.peek() == target) { // 스택의 마지막이 목표 수열을 만들 수 있으면 pop
                stack.pop();
                j++;
                sb.append("-").append('\n');
            }

            else { // 오름차순으로 다음 수를 push
                stack.push(i);
                i++;
                if (i <= n+1) {
                    sb.append("+").append('\n');
                }
            }
        }

        if (j == n) System.out.println(sb); // j = 목표 수열이 담긴 배열의 인덱스 값, n이란 것은 목표 수열을 만들었다는 의미
        else System.out.println("NO");
        sc.close();
    }
}