package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1083번
public class Sort {
    static int S, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        arr = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        S = Integer.parseInt(br.readLine());

        int currentIdx = 0;
        int max;
        int maxI;

        while (S > 0 && currentIdx < cnt) {
            max = arr[currentIdx];
            maxI = currentIdx;
            for (int i = currentIdx + 1; i < cnt; i++) {
                if (max < arr[i]) {
                    if (i - currentIdx <= S) {
                        max = arr[i];
                        maxI = i;
                    }
                }
            }

            if (currentIdx != maxI) {
                sort(currentIdx, maxI);
            }
            currentIdx++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            if (i == cnt - 1) {
                sb.append(arr[i]);
            }
            else {
                sb.append(arr[i] + " ");
            }
        }
        System.out.println(sb);
    }

    static void sort(int currentIdx, int maxI) {
        for (int i = maxI; i > currentIdx; i--) {
            int a = arr[i];
            int b = arr[i - 1];

            arr[i - 1] = a;
            arr[i] = b;
        }
        S -= maxI - currentIdx;
    }
}
