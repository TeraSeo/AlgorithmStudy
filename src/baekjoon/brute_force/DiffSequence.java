package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiffSequence {
    static int N;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            boolean isTrue = checkSequence(i);
            if (isTrue) ans++;
        }

        System.out.println(ans);
    }

    static boolean checkSequence(int num) {
        if (num < 100) return true;
        int hundreds = num / 100;
        int tens = (num / 10) % 10;
        int ones = num % 10;

        return (hundreds - tens) == (tens - ones);
    }
}
