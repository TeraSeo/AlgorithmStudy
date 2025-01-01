package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1062번
public class Lesson {
    static String[] words;
    static boolean[] isVisited;
    static int max = 0;
    static int N, K;
    public static void main(String[] args) throws IOException {
        int ans = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        isVisited = new boolean[26];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String substring = s.substring(4, s.length() - 4);
            words[i] = substring;
        }

        if (K < 5) {
            System.out.println("0");
            return;
        }
        else if (K == 26) {
            System.out.println(N);
            return;
        }

        isVisited['a' - 'a'] = true;
        isVisited['n' - 'a'] = true;
        isVisited['t' - 'a'] = true;
        isVisited['i' - 'a'] = true;
        isVisited['c' - 'a'] = true;

        recursion(0, 0);

        System.out.println(max);
    }

    public static void recursion(int alpha, int len) {
        if (K - 5 == len) {
            int cnt = 0;
            for (int i = 0; i < words.length; i++) {
                boolean isTrue = true;

                char[] chars = words[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (!isVisited[chars[j] - 'a']) isTrue = false;
                }

                if (isTrue) cnt++;
            }

            max = Math.max(max, cnt);
        }

        for (int i = alpha; i < 26; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                recursion(i, len + 1);
                isVisited[i] = false;
            }
        }
    }
}