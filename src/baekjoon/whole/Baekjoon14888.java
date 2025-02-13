package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14888 {
    static int N;
    static long[] numArr;
    static long max = Integer.MIN_VALUE;
    static long min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numArr = new long[N];
        int plus_cnt, minus_cnt, multiple_cnt, divide_cnt;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Long.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plus_cnt = Integer.parseInt(st.nextToken());
        minus_cnt = Integer.parseInt(st.nextToken());
        multiple_cnt = Integer.parseInt(st.nextToken());
        divide_cnt = Integer.parseInt(st.nextToken());

        recursion(plus_cnt, minus_cnt, multiple_cnt, divide_cnt, 1, numArr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void recursion(int plus_cnt, int minus_cnt, int multiple_cnt, int divide_cnt, int idx, long total) {
        if (idx == N) {
            max = Math.max(max, total);
            min = Math.min(min, total);

            return;
        }

        if (plus_cnt > 0) recursion(plus_cnt - 1, minus_cnt, multiple_cnt, divide_cnt, idx + 1, total + numArr[idx]);
        if (minus_cnt > 0) recursion(plus_cnt, minus_cnt - 1, multiple_cnt, divide_cnt, idx + 1, total - numArr[idx]);
        if (multiple_cnt > 0) recursion(plus_cnt, minus_cnt, multiple_cnt - 1, divide_cnt, idx + 1, total * numArr[idx]);
        if (divide_cnt > 0) recursion(plus_cnt, minus_cnt, multiple_cnt, divide_cnt - 1, idx + 1, total / numArr[idx]);
    }
}

// 브루트포스 알고리즘 문제이다
// 전체 탐색을 하여서 최대값과 최솟값을 얻는 문제이다