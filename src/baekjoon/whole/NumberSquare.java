package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1051번
public class NumberSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int max = 0;
        int minSide = Math.min(N, M);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] num = br.readLine().split("");
            for (int j = 0; j < num.length; j++) {
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int l = max; l < minSide; l++) {
                    if (i + l < N && j + l < M) {
                        if (arr[i][j] == arr[i + l][j] && arr[i][j] == arr[i][j + l] && arr[i][j] == arr[i + l][j + l]) {
                            max = l;
                        }
                    }
                }
            }
        }

        System.out.println((max + 1) * (max + 1));
    }
}
