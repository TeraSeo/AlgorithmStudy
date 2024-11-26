package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquaredSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            int max_sqrt = (int) Math.sqrt(i);
            arr[i] = arr[i - max_sqrt * max_sqrt] + 1;
            for (int l = 1; l <= max_sqrt; l++) {
                arr[i] = Math.min(arr[i], arr[i - l * l] + 1);
            }
        }

        System.out.println(arr[num]);
    }
}
