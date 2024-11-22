package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CEO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[k + 1][n + 1];
            for (int l = 1; l <= n; l++) {
                arr[0][l] = l;
            }

            for (int l = 1; l <= k; l++) {
                for (int j1 = 1; j1 <= n; j1++) {
                    int sum = 0;
                    for (int j2 = 1; j2 <= j1; j2++) {
                        sum += arr[l - 1][j2];
                    }
                    arr[l][j1] = sum;
                }
            }

            System.out.println(arr[k][n]);
        }
    }
}