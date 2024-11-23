package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RockGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int div = N / 3;
        int remainder = N % 3;

        if (div % 2 == 0) {
            if (remainder % 2 == 0) {
                System.out.println("CY");
            }
            else {
                System.out.println("SK");
            }
        }
        else {
            if (remainder % 2 == 0) {
                System.out.println("SK");
            }
            else {
                System.out.println("CY");
            }
        }
    }
}
