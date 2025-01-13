package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1174번
public class ReducingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        if (cnt == 1023) {
            System.out.println("9876543210");
        }
        else if (cnt > 1023) {
            System.out.println(-1);
        }
        else if (cnt == 0) System.out.println(0);
        else {
            for (int a = 0; a < 10; a++) {
                for (int b = 0; a == 0 ? b < 10 : b < a; b++) {
                    for (int c = 0; (a == 0 && b == 0) ? c < 10 : c < b; c++) {
                        for (int d = 0; (a == 0 && b == 0 && c == 0) ? d < 10 : d < c; d++) {
                            for (int e = 0; (a == 0 && b == 0 && c == 0 && d == 0) ? e < 10 : e < d; e++) {
                                for (int f = 0; (a == 0 && b == 0 && c == 0 && d == 0 && e == 0) ? f < 10 : f < e; f++) {
                                    for (int g = 0; (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0) ? g < 10 : g < f; g++) {
                                        for (int h = 0; (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0 && g == 0) ? h < 10 : h < g; h++) {
                                            for (int i = 0; (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0 && g == 0 && h == 0) ? i < 10 : i < h; i++) {
                                                cnt--;
                                                if (cnt == 0) {
                                                    System.out.println(a * 100000000 + b * 10000000 + c * 1000000 + d * 100000 + e * 10000 + f * 1000 + g * 100 + h * 10 + i);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
