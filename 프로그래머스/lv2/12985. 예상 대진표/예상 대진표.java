class Solution
{
    public int solution(int n, int x, int y)
    {
        int answer = 0;
        int a = Math.min(x, y);
        int b = Math.max(x, y);
        /*
        a, b는 라운드를 수행할 때 마다 원래 번호가 아니라 순서대로 번호를 새로 부여받는다.
        라운드별로 그 번호를 부여받는 순서는 1번부터 n/2번까지이므로 마지막엔 1, 2번이 남아 최종 라운드에서 붙게 될 것임
        */
        while(a != b) {
            b = (b+1) / 2;
            a = (a+1) / 2;
            answer++;
        }
        return answer;
    }
}