package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1512번
public class CycledText {

    static int aCnt, cCnt, gCnt, tCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= M; i++) {

            int whole_sum = 0;
            for (int k = 0; k < i; k++) {
                aCnt = 0;
                cCnt = 0;
                gCnt = 0;
                tCnt = 0;

                for (int j = 0; j < arr.length; j += i) {
                    if (j + k < arr.length) {
                        addCnt(arr[j + k]);
                    }
                }

                int sum = aCnt + cCnt + gCnt + tCnt;
                int max = Math.max(Math.max(aCnt, cCnt), Math.max(gCnt, tCnt));
                whole_sum += sum - max;
            }

            ans = Math.min(ans, whole_sum);
        }

        System.out.println(ans);
    }

    static void addCnt(char c) {
        if (c == 'A') {
            aCnt++;
        }
        else if (c == 'C') {
            cCnt++;
        }
        else if (c == 'G') {
            gCnt++;
        }
        else {
            tCnt++;
        }
    }
}
