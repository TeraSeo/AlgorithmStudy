package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Backjoon 1025번
public class SquaredNum {
    static int[][] arr;
    static long max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = s[j] - '0';
            }
        }

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                for (int c = -N; c < N; c++) {
                    for (int d = -M; d < M; d++) {
                        if (c == 0 && d == 0) continue;

                        int x = b;
                        int y = a;
                        int num = 0;

                        while (x >= 0 && x < M && y >= 0 && y < N) {
                            num = num * 10 + arr[y][x];
                            if (isSquared(num)) max = Math.max(max, num);
                            x += d;
                            y += c;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    static boolean isSquared(int num) {
        if (Math.sqrt(num) % 1 == 0) return true;
        return false;
    }
}

