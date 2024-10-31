package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Out {
    static int[][] arr;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        arr = new int[cnt][2];
        ans = new int[cnt + 1];

        for (int i = 0; i < cnt; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        for (int i = 0; i < cnt; i++) {
            if (arr[i][0] + i <= cnt) {
                ans[arr[i][0] + i] = Math.max(ans[arr[i][0] + i], ans[i] + arr[i][1]);
            }
            ans[i + 1] = Math.max(ans[i], ans[i + 1]);
        }

        System.out.println(ans[cnt]);
    }
}
