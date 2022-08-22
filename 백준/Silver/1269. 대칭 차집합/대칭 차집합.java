import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 세 줄 입력을 받으므로 StringTokenizer을 세번 선언(다르게 바꿀 수 있는지 확인해보기)
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        // O(1)로 탐색하기 위해 List가 아닌 HashSet 사용
        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 결과를 담기 위한 ArrayList
        List<Integer> result = new ArrayList<Integer>();

        while (st1.hasMoreTokens()) { // StringTokenizer이 갖고 있는 토큰의 개수만큼 순회하면서 SetA에 추가
            setA.add(Integer.parseInt(st1.nextToken()));
        }

        while (st2.hasMoreTokens()) { // 이하동일
            setB.add(Integer.parseInt(st2.nextToken()));
        }

        for (Integer integer : setA) { // forEach로 setA의 item을 setB에 포함하지 않는지 검사후 result에 추가
            if (!setB.contains(integer)) result.add(integer);
        }


        for (Integer integer : setB) { // 이하동일
            if (!setA.contains(integer)) result.add(integer);
        }

        System.out.println(result.size());
    }
}
