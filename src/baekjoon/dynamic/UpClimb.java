package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpClimb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[cnt + 1][10];
        arr[1][0] = 1;
        for (int i = 1; i <= 9; i++) { arr[1][i] = 1; }

        for (int i = 2; i <= cnt; i++) {
            arr[i][0] = 1;
            for (int l = 1; l <= 9; l++) {
                arr[i][l] = (arr[i][l - 1] + arr[i - 1][l]) % 10007;
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) { sum += arr[cnt][i] % 10007; }
        System.out.println(sum % 10007);
    }
}
