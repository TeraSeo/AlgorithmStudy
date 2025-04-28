package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int a = Integer.parseInt(split[1]);
        int b = Integer.parseInt(split[2]);

        int round = 0;
        while (a != b) {
            if (a % 2 != 0) a += 1;
            if (b % 2 != 0) b += 1;

            a /= 2;
            b /= 2;

            round++;
        }

        System.out.println(round);
    }
}