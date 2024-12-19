package baekjoon.whole;

import java.io.*;

public class Z {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        long r = Integer.parseInt(split[1]);
        long c = Integer.parseInt(split[2]);

        long row_count = 0;
        for (int n = N - 1; n > 0; n--) {
            if ((long) Math.pow(2, n) <= r) {
                r-= (long) Math.pow(2, n);
                row_count += ((long) Math.pow((long) Math.pow(2, n), 2)) * 2;
            }
        }
        if (r == 1) {
            row_count += 2;
        }

        long col_count = 0;
        for (int n = N - 1; n > 0; n--) {
            if ((long) Math.pow(2, n) <= c) {
                c-= (long) Math.pow(2, n);
                col_count += (long) Math.pow((long) Math.pow(2, n), 2);
            }
        }
        if (c == 1) {
            col_count += 1;
        }

        System.out.println(row_count + col_count);
    }
}