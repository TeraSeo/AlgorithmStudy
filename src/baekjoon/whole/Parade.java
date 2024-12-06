package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1080번
public class Parade {

    static int N, M;
    static int[][] arr_1, arr_2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr_1 = new int[N][M];
        arr_2 = new int[N][M];
        int ans = 0;

        for (int y = 0; y < N; y++) {
            String[] s = br.readLine().split("");
            for (int x = 0; x < M; x++) {
                arr_1[y][x] = Integer.parseInt(s[x]);
            }
        }

        for (int y = 0; y < N; y++) {
            String[] s = br.readLine().split("");
            for (int x = 0; x < M; x++) {
                arr_2[y][x] = Integer.parseInt(s[x]);
            }
        }

        for (int y= 0; y <= N - 3; y++) {
            for (int x = 0; x <= M - 3; x++) {
                if (arr_1[y][x] != arr_2[y][x]) {
                    reverse(x, y);
                    ans++;
                }
            }
        }

        boolean isSame = isWholeSame();
        if (isSame) System.out.println(ans);
        else System.out.println(-1);
    }

    public static void reverse(int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr_1[y + i][x + j] == 1) arr_1[y + i][x + j] = 0;
                else arr_1[y + i][x + j] = 1;
            }
        }
    }

    public static boolean isWholeSame() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (arr_1[y][x] != arr_2[y][x]) {
                    return false;
                }
            }
        }

        return true;
    }
}
