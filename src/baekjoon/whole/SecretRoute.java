package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SecretRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int secretRoute = Integer.parseInt(st.nextToken());
            int[] route = new int[]{start, end, secretRoute};
            arr[i] = route;
        }

        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[D] = D;

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            int[] route = arr[i];
            for (int j = 1; j <= D; j++) {
                dp[j] = Math.min(dp[j - 1] + 1, dp[j]);
                if (j == route[1]) {
                    dp[j] = Math.min(dp[route[0]] + route[2], dp[j]);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
