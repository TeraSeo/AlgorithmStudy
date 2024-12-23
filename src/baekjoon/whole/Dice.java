package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dice {
    public static void main(String[] args) throws IOException {
        long[] dice = new long[6];
        long min_1_surface = Long.MAX_VALUE;
        long min_2_surface = Long.MAX_VALUE;
        long min_3_surface = Long.MAX_VALUE;
        long sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());

        if (N == 1) {
            long max = Long.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                dice[i] = Long.parseLong(st.nextToken());
                max = Math.max(max, dice[i]);
                sum += dice[i];
            }
            sum -= max;
        }
        else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                dice[i] = Integer.parseInt(st.nextToken());
                min_1_surface= Math.min(min_1_surface, dice[i]);
            }

            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (i + j != 5) {
                        min_2_surface = Math.min(min_2_surface, dice[i] + dice[j]);
                    }
                }
            }

            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    for (int l = j + 1; l < 6; l++) {
                        if (i + j != 5 && j + l != 5 && i + l != 5) {
                            min_3_surface = Math.min(min_3_surface, dice[i] + dice[j] + dice[l]);
                        }
                    }
                }
            }

            long surface_1_cnt = (N * N - 3 * N + 2) * 4 + N * N - 4 * N + 4;
            long surface_2_cnt = 8 * N - 12;
            long surface_3_cnt = 4;

            long surface_1_sum = surface_1_cnt * min_1_surface;
            long surface_2_sum = surface_2_cnt * min_2_surface;
            long surface_3_sum = surface_3_cnt * min_3_surface;
            sum = surface_1_sum + surface_2_sum + surface_3_sum;
        }

        System.out.println(sum);
    }
}
