package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardMix {
    static int[] P, S, temp, initial_arr;
    static int cnt;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());

        temp = new int[cnt];
        P = new int[cnt];
        S = new int[cnt];
        initial_arr = new int[cnt];

        String p_s = br.readLine();
        StringTokenizer st = new StringTokenizer(p_s);
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            P[i] = num;
            initial_arr[i] = num;
        }

        String s_s = br.readLine();
        st = new StringTokenizer(s_s);
        for (int i = 0; i < cnt; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        boolean isCorrect = checkIsCorrect();
        boolean isOverturn = false;
        while (!isCorrect && !isOverturn) {
            rearrangeList();
            isCorrect = checkIsCorrect();
            if (Arrays.equals(initial_arr, P)) isOverturn = true;
        }

        System.out.println(isOverturn ? -1 : ans);
    }

    static void rearrangeList() {
        for (int i = 0; i < cnt; i++) {
            temp[i] = P[i];
        }
        for (int i = 0; i < cnt; i++) {
            P[S[i]] = temp[i];
        }
        ans++;
    }

    static boolean checkIsCorrect() {
        for (int i = 0; i < cnt / 3; i++) {
            if (P[i * 3] != 0 || P[i * 3 + 1] != 1 || P[i * 3 + 2] != 2) return false;
        }
        return true;
    }
}
