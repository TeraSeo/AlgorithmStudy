package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalenDromFactory {
    static StringBuilder sb;
    static int[][] dp = new int[51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder(br.readLine());
        int result;

        dps(dp, 0, 0);
        result = dp[0][sb.length() - 1];

        for (int i = 0; i < sb.length(); i++) {
            for (int j = i + 1; j < sb.length(); j++) {
                dps(dp, i, j);
                result = Math.min(result, dp[0][sb.length() - 1] + 1);
                swap(i, j);
            }
        }

        System.out.println(result);
    }

    static void swap(int a, int b) {
        char temp = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, temp);
    }

    static void dps(int[][] dp, int a, int b) {
        swap(a, b);

        for (int i = 0; i < sb.length(); i++) {
            dp[i][i] = 0;
            if (i < sb.length() - 1) {
                if (sb.charAt(i) == sb.charAt(i + 1)) dp[i][i + 1] = 0;
                else dp[i][i + 1] = 1;
            }
        }

        for (int i = 2; i < sb.length(); i++) {
            for (int j = 0; j + i < sb.length(); j++) {
                dp[j][j + i] = Math.min(dp[j + 1][j + i] + 1, dp[j][j + i - 1] + 1);
                if (sb.charAt(j + i) == sb.charAt(j)) dp[j][j + i] = Math.min(dp[j + 1][j + i - 1], dp[j][j + i]);
                else dp[j][j + i] = Math.min(dp[j + 1][j + i - 1] + 1, dp[j][j + i]);
            }
        }
    }
}
