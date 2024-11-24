package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardBuy {

    static int[] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        ans = new int[N + 1];

        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(split[i - 1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i] = Math.max(ans[i - j] + arr[j], ans[i]);
            }
        }

        System.out.println(ans[N]);
    }
}
