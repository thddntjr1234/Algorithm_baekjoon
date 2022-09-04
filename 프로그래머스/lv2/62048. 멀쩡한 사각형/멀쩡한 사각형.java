class Solution {
    public long solution(int w, int h) {
        int a = w;
        int b = h;
        // 최대공약수를 구하는 유클리드 호제법 알고리즘 두 수의 나머지를 계산해 나머지가 0이 될 때의 나누는 수 = gcd
        while(b != 0) { 
            int remain = a%b;
            a = b;
            b = remain;
        }
        int gcd = a;
        
        /*
        문제 풀이 핵심은 대각선이 지나는 정사각형에서 일정한 패턴이 반복되는 것을 발견하는 것이고
        이 패턴이 최대공약수 만큼만 반복되며, 각 패턴의 w, h는 주어진 w, h을 최대공약수로 나눈 수인 것이다.
        answer에 주입 시 w*h는 각 1억이므로 int타입이 지원하는 수의 제한을 가볍게 넘기니
        long으로 지정해줘서 오버플로가 발생하지 않도록 해야 함.
        */
        long answer = ((long)w*h) - (((w/gcd) + (h/gcd) -1) * gcd);
        
        return answer;
    }
}