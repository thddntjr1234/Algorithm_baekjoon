import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Set<String> result = new HashSet<>();

        /* 
        java.lang.String 클래스의 substring 메소드를 사용해 문자열을 자른다 
        substring(startIndex, endIndex)는 파이썬의 문자열 인덱스처럼 endIndex 바로 이전의 값까지만 자름
        */ 
        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }
        System.out.println(result.size());
    }
}