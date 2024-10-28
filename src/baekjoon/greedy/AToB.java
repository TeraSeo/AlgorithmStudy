package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AToB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");

        int a = Integer.parseInt(splits[0]);
        int b = Integer.parseInt(splits[1]);

        int res = 1;

        while (a != b && a < b) {
            if (b % 2 == 0) {
                res++;
                b /= 2;
            }
            else {
                String str = String.valueOf(b);
                if (str.charAt(str.length() -1) == '1') {
                    res++;
                    b = Integer.parseInt(str.substring(0, str.length() - 1));
                }
                else {
                    res = -1;
                    break;
                }
            }
        }
        if (a > b) res = -1;

        System.out.println(res);
    }
}
