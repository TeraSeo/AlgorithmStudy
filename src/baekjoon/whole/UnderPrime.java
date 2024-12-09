package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Baekjoon 1124번
public class UnderPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 2; i <= B; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    arr[i] = arr[i / j] + 1;
                    if (i >= A && i <= B) {
                        numList.add(arr[i]);
                    }
                    break;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (arr[numList.get(i)] == 1) ans ++;
        }

        System.out.println(ans);
    }
}
