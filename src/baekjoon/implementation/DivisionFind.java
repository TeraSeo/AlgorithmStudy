package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisionFind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String upper = "1";
        String lower = "1";
        boolean isReverse = false;

        if (num != 1) {
            int i = 1;
            while (num > i) {
                num -= i;
                i++;
                isReverse = !isReverse;
            }
            if (isReverse) {
                if (num == 0) {
                    upper = String.valueOf(i);
                    lower = "1";
                }
                else if (num == 1) {
                    upper = "1";
                    lower = String.valueOf(i);
                }
                else {
                    upper = String.valueOf(num);
                    lower = String.valueOf(i - (num - 1));
                }
            }
            else {
                if (num == 0) {
                    upper = "1";
                    lower = String.valueOf(i);
                }
                else if (num == 1) {
                    upper = String.valueOf(i);
                    lower = "1";
                }
                else {
                    upper = String.valueOf(i - (num - 1));
                    lower = String.valueOf(num);
                }
            }
        }
        System.out.println(upper + "/" + lower);
    }
}
