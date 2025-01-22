package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 1188번
public class FoodTaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double N = Double.parseDouble(st.nextToken());
        double M = Double.parseDouble(st.nextToken());
        double perPerson = N / M;

        int cnt = (int) (perPerson / 1.0);
        int i = (int) (N - (int) (cnt * M));
        int[] arr = new int[i];
        Arrays.fill(arr, (int) M);

        int idx = 0;
        int ans = 0;

        while (i > 0) {
            int val = arr[idx];
            val -= i;
            if (val == 0) {
                arr[idx] = 0;
                if (idx == i - 1 && arr[idx] == 0) break;
                idx++;
            }
            else {
                if (val > 0) {
                    arr[idx] = val;
                }
                else {
                    idx++;
                    arr[idx] += val;
                }
                ans++;
            }
        }

        System.out.println(ans);
    }
}
