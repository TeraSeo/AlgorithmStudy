package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= num; i++) {
            int min = Integer.MAX_VALUE;
            for (int l = 1; l * l <= i; l++) {
                min = Math.min(min, arr[i - l * l]);
            }
            arr[i] = min + 1;
        }

        System.out.println(arr[num]);
    }
}
