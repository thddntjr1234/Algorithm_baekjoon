import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M, count = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// ArrayList의 contains 메소드는 O(n)을 가진 반면 HashSet의 contains 메소드는 O(1)을 가진다.
		Set<String> base = new HashSet<String>();
		List<String> check = new ArrayList<String>();
		for (int i=0; i<N; i++) {
			base.add(br.readLine());
		}

		for (int i=0; i<M; i++) {
			check.add(br.readLine());
		}

		List<String> result = new ArrayList<String>();
		for (int i=0; i<M; i++) {
			if (base.contains(check.get(i))) { // 듣도 못한 사람 리스트에 검사할 사람의 이름이 존재하면
				count += 1;
				result.add(check.get(i));
			} 
		}

		// 사전순으로 명단 출력하기 위해 오름차순 정렬
		result.sort(Comparator.naturalOrder());
		System.out.println(count);
		for (String string : result) {
			System.out.println(string);
		}
	}
}