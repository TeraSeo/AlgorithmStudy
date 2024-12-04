package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split1 = br.readLine().split("");
        String[] split2 = br.readLine().split("");
        int[][] dp = new int[split1.length + 1][split2.length + 1];

        for (int i = 1; i <= split1.length; i++) {
            for (int j = 1; j <= split2.length; j++) {
                if (split1[i - 1].equals(split2[j - 1])) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[split1.length][split2.length]);
    }
}
