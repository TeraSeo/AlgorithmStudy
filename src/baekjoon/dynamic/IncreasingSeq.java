package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreasingSeq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int[] arr = new int[cnt];
        int[] sum_arr = new int[cnt];
        String[] split = br.readLine().split(" ");
        int max = 0;

        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < cnt; i++) {
            sum_arr[i] = arr[i];
            for (int l = 0; l < i; l++) {
                if (arr[i] > arr[l]) {
                    sum_arr[i] = Math.max(sum_arr[i], arr[i] + sum_arr[l]);
                }
            }
            max = Math.max(sum_arr[i], max);
        }

        System.out.println(max);
    }
}
