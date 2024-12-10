package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1027번
public class TallStructure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int ans = 0;

        int[] arr = new int[cnt + 1];
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= cnt; i++) {
            arr[i] = Integer.parseInt(split[i - 1]);
        }

        for (int x1 = 1; x1 <= cnt; x1++) {
            int count = 0;

            double temp = Double.MAX_VALUE * -1;
            for (int x2 = x1 + 1; x2 <= cnt; x2++) {
                double gradient = (double) (arr[x2] - arr[x1]) / (x2 - x1);
                if (gradient > temp) {
                    temp = gradient;
                    count++;
                }
            }

            temp = Double.MAX_VALUE;
            for (int x2 = x1 - 1; x2 >= 1; x2--) {
                double gradient = (double) (arr[x1] - arr[x2]) / (x1 - x2);
                if (gradient < temp) {
                    temp = gradient;
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
}