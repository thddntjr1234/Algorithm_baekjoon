import java.util.*;

class Solution {
    public long solution(int[] tmp) {
        
        long[] arr = Arrays.stream(tmp).asLongStream().toArray();
        long answer = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            /* 
            answer의 초기값은 arr[0]으로 잡고(그렇지 않으면 arr[i] = arr[i-1], arr[i]로 배열을 사용해서 값을 담아가야 함)
            answer, arr[i]에 대해 lcd함수를 호출한 결과를 answer에 담아가면서 반복 호출하면
            lcd(두개씩 lcd계산한 결과, 새로운 값) 이런 식이 됨
            i가 마지막까지 순회하면 모든 값에 대한 lcd를 구한 결과를 갖게 된다
            */
            answer = lcd(answer, arr[i]);
        }
        return answer;
    }
    
    public long lcd(long a, long b) {
        long min = (a > b) ? b : a;
        long gcd = 1;
        
        // 이런 방식으로도 gcd를 구할 수 있다
        for(int i=1; i<=min; i++) {
            if(a%i == 0 && b%i == 0) gcd = i;
        }
        //유클리드 호제법
        // long x = Math.max(a, b);
        // long y = Math.min(a, b);
        // while(y != 0) {
        //     long r = x % y;
        //     x = y;
        //     y = r;
        // }
        // gcd = x;
        
        return (a*b)/gcd;
    }
}