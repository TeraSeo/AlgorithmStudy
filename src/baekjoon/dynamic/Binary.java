package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Binary {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        if (cnt == 1 || cnt == 2) {
            System.out.println(1);
        }
        else {
            long[] ans = new long[cnt];
            ans[0] = 1;
            ans[1] = 1;
            ans[2] = 2;
            for (int i = 3; i < cnt; i++) {
                ans[i] = ans[i - 1] + ans[i - 2];
            }
            System.out.println(ans[cnt - 1]);
        }
    }
}
