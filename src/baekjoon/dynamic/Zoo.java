package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[cnt][3];
        int ans = 0;
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;

        for (int i = 1; i < cnt; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2];
            arr[i][1] = arr[i - 1][0] + arr[i - 1][2];
            arr[i][2] = arr[i - 1][0] + arr[i - 1][1];
            arr[i][0] %= 9901;
            arr[i][1] %= 9901;
            arr[i][2] %= 9901;
        }

        ans += arr[cnt - 1][0];
        ans += arr[cnt - 1][1];
        ans += arr[cnt - 1][2];

        System.out.println(ans % 9901);
    }
}
