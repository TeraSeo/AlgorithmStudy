package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1030번
public class Fractal {
    static int s, N, K, R1, R2, C1, C2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        s = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);
        R1 = Integer.parseInt(split[3]);
        R2 = Integer.parseInt(split[4]);
        C1 = Integer.parseInt(split[5]);
        C2 = Integer.parseInt(split[6]);

        StringBuilder result = new StringBuilder();
        for (int r = R1; r <= R2; r++) {
            for (int c = C1; c <= C2; c++) {
                result.append(isBlack(s, r, c) ? "1" : "0");
            }
            result.append("\n");
        }

        System.out.print(result);
    }

    static boolean isBlack(int sec, int r, int c) {
        while (sec > 0) {
            int size = (int) Math.pow(N, sec - 1);
            int centerStart = (N - K) / 2 * size;
            int centerEnd = centerStart + K * size;

            if ((r % (N * size)) >= centerStart && (r % (N * size)) < centerEnd &&
                    (c % (N * size)) >= centerStart && (c % (N * size)) < centerEnd) {
                return true;
            }

            r %= size;
            c %= size;
            sec--;
        }

        return false;
    }
}
