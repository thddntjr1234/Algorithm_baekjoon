import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] progression = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(br.readLine());
        int[] nums = new int[2000000];
        int count = 0;

        /* 
        기존엔 해당 구문에서 for문으로 progression을 순회하면서 해당 숫자 인덱스로 하는 nums[idx]의 값을 1로 변경했으나
        이렇게 미리 1로 설정하는 경우에는 x-progression[idx]를 통해서 접근할 때 progression[idx] == x 인 경우 같은 쌍이 있는 것으로 처리하게 된다.
        또한 한 순서쌍에 대해 첫번째, 두번째 수에서 모두 count 처리가 될 수 있으므로 처음부터 값이 있다고 1로 초기화하지 않아야 한다.
        */ 

        // x-progression[idx] 값을 nums에서 조회해서 1이면 count ++, 만약  nums[progression[idx]] = 1로 설정하여 이후 맞이하는 순서쌍에서 조건문을 통과할 수 있도록 함
        for (int idx = 0; idx < n; idx++) {
            if ((x - progression[idx] > 0) && nums[x - progression[idx]] == 1) count++;
            nums[progression[idx]] = 1;
        }

        System.out.println(count);
    }
}
