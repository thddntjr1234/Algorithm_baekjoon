import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        for (int i = b.length() - 1; i >= 0; i--) {
            System.out.println(Integer.parseInt(a) * Integer.parseInt(String.valueOf(b.charAt(i))));
        }
        System.out.println(Integer.parseInt(a) * Integer.parseInt(b));
    }
}