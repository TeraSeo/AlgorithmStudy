package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Out {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        arr = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            String[] splits = s.split(" ");
            arr[i] = new int[]{Integer.parseInt(splits[0]), Integer.parseInt(splits[1])};
        }

        int res = 0;
        for (int i = 0; i < cnt; i++) {
            int sum = 0;
            for (int l = i; l < cnt; l++) {
                System.out.println(l);
                if (l + arr[l][0] - 1 < cnt) {
                    sum += arr[l][1];
                }
                l += (arr[l][0] - 1);
            }
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}
