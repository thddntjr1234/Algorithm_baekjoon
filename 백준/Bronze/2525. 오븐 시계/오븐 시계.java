import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] startTime = br.readLine().split(" ");
        int requiredTime = Integer.parseInt(br.readLine());

        int hour = Integer.parseInt(startTime[0]);
        int minute = Integer.parseInt(startTime[1]) + requiredTime;
        if (minute >= 60 ) {
            hour += minute / 60;
            minute = minute % 60;
        }

        if (hour >= 24) {
            hour -= 24;
        }

        System.out.println(String.format("%d %d", hour, minute));
    }
}