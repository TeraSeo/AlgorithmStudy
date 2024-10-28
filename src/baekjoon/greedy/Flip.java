package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flip {
    public static void main(String[] args) throws IOException {
        int one_cnt = 0;
        int zero_cnt = 0;
        int lastNum;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split("");
        lastNum = Integer.parseInt(splits[0]);
        if (lastNum == 0) zero_cnt++;
        else one_cnt++;
        for (int i = 1; i < splits.length; i++) {
            if (Integer.parseInt(splits[i]) != lastNum) {
                lastNum = Integer.parseInt(splits[i]);
                if (lastNum == 0) zero_cnt++;
                else one_cnt++;
            }
        }

        if (one_cnt > zero_cnt) {
            System.out.println(zero_cnt);
        }
        else {
            System.out.println(one_cnt);
        }
    }
}