package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100];
        int[][] arr = new int[N][2];

        StringTokenizer health = new StringTokenizer(br.readLine());
        StringTokenizer happiness = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(health.nextToken());
            arr[i][1] = Integer.parseInt(happiness.nextToken());

            for (int j = 99; j >= arr[i][0]; j--) {
                dp[j] = Math.max(dp[j - arr[i][0]] + arr[i][1], dp[j]);
            }
        }

        System.out.println(dp[99]);
    }
}
