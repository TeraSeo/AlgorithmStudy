package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        while (L <= 100 && L <= N + 1) {
            long div = N / L;
            if (L % 2 == 0) {
                if (N % L != 0) {
                    if ((div + div + 1) * (L / 2) == N && div - (L / 2 - 1) >= 0) {
                        for (int i = L / 2 - 1; i >= 0; i--) {
                            sb.append(div - i + " ");
                        }
                        for (int i = 1; i < L / 2; i++) {
                            sb.append(div + i + " ");
                        }
                        sb.append(div + L / 2 + " ");
                    }
                }
            }
            else {
                if (N % L == 0) {
                    if (div * L == N && div - L / 2 >= 0) {
                        for (int i = L / 2; i > 0; i--) {
                            sb.append(div - i + " ");
                        }
                        sb.append(div + " ");
                        for (int i = 1; i < L / 2; i++) {
                            sb.append(div + i + " ");
                        }
                        sb.append(div + L / 2 + " ");
                    }
                }
            }
            L++;

            if (sb.length() != 0) break;
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sb);
        }
    }
}
