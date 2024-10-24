package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumCnt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = Long.parseLong(br.readLine());
        int i = 0;
        while (sum > 0) {
            i++;
            sum -= i;
        }
        if (sum < 0) i -= 1;
        System.out.println(i);
    }
}
