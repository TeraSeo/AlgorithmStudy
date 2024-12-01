package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sticker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];

            for(int l = 0; l < 2; l++) {
                String[] split = br.readLine().split(" ");
                for (int j = 0; j < split.length; j++) {
                    arr[l][j] = Integer.parseInt(split[j]);
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            for (int l = 1; l < n; l++) {
                dp[0][l] = Math.max(dp[1][l - 1] + arr[0][l], dp[0][l]);
                dp[1][l] = Math.max(dp[0][l - 1] + arr[1][l], dp[1][l]);

                if (l + 1 < n) {
                    dp[1][l + 1] = Math.max(dp[0][l - 1] + arr[1][l + 1], dp[1][l + 1]);
                    dp[0][l + 1] = Math.max(dp[1][l - 1] + arr[0][l + 1], dp[0][l + 1]);
                }

            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}
