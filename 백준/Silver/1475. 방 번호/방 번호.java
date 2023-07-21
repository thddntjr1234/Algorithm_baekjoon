import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] roomNums = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] nums = new int[10];
        
        for (int idx : roomNums) {
            nums[idx]++;
        }

        int max = 1;
        for (int idx = 0; idx < 10; idx++) {
            int num = nums[idx];

            if (idx == 6 || idx == 9) continue;
            if (num > max) max = num;
        }

        System.out.println(Math.max(max, (nums[6]+nums[9]+1)/2));
    }
}
