package baekjoon.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Navigation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int[][] arr = new int[cnt + 1][cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            String[] split = br.readLine().split(" ");
            for (int l = 0; l < cnt; l++) {
                arr[i][l + 1] = Integer.parseInt(split[l]);
            }
        }

        solution(arr, cnt);

        for (int i = 1; i <= cnt; i++) {
            StringBuilder sb = new StringBuilder();
            for (int l = 1; l <= cnt; l++) {
                sb.append(arr[i][l] + " ");
            }
            System.out.println(sb);
        }
    }

    static void solution(int[][] arr, int cnt) {
        for (int k = 1; k <= cnt; k++) {
            for (int i = 1; i <= cnt; i++) {
                for (int l = 1; l <= cnt; l++) {
                    if (arr[i][k] != 0 && arr[k][l] != 0) {
                        arr[i][l] = 1;
                    }
                }
            }
        }
    }
}
