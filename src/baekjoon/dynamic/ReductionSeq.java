package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReductionSeq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int result = 0;

        int[] arr = new int[cnt];
        int[] cnt_arr = new int[cnt];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        for (int a = 0; a < cnt; a++) {
            cnt_arr[a] = 1;
            for (int b = 0; b < a; b++) {
                if (arr[b] > arr[a]) {
                    cnt_arr[a] = Math.max(cnt_arr[a], cnt_arr[b] + 1);
                }
            }
            result = Math.max(result, cnt_arr[a]);
        }

        System.out.println(result);
    }
}
