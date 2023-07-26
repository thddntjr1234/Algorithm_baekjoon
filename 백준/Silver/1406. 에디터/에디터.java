import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character> editor = new LinkedList<>();
        String initial = br.readLine();
        for (int i = 0; i < initial.length(); i++) {
            editor.add(initial.charAt(i));
        }
        int count = Integer.parseInt(br.readLine());
        
        // 기존 LinkedList는 좌우 끝을 제외한 곳에서 삽입/삭제 시 O(N)의 시간이 소요되기 때문에 시간초과가 발생한다.
        // ListIterator을 사용하면 현재 iter의 커서에서 작업을 수행할 수 있으므로 시간초과를 해결한다.
        ListIterator<Character> iter = editor.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char instruction = st.nextToken().charAt(0);

            if (instruction == 'L' && iter.hasPrevious()) iter.previous();
            else if (instruction == 'D' && iter.hasNext()) iter.next();
            else if (instruction == 'B' && iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            }
            else if (instruction == 'P') { // 'P일때'
                char character = st.nextToken().charAt(0);
                iter.add(character);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : editor) {
            sb.append(character);
        }
        System.out.println(sb.toString());
    }
}
