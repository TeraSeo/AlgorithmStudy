package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baekjoon 1469번
public class Shome {
    static int N;
    static ArrayList<Integer> numList = new ArrayList<>();
    static ArrayList<int[]> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numList.add(Integer.valueOf(st.nextToken()));
        }

        int[] arr = new int[N * 2];
        Arrays.fill(arr, -1);

        recursion(arr, 0);

        Collections.sort(ans, (a, b) -> {
            int minLength = Math.min(a.length, b.length);
            for (int i = 0; i < minLength; i++) {
                if (a[i] != b[i]) {
                    return Integer.compare(a[i], b[i]);
                }
            }
            return Integer.compare(a.length, b.length);
        });

        if (ans.size() > 0) {
            for (int i = 0; i < N * 2 - 1; i++) {
                System.out.print(ans.get(0)[i] + " ");
            }
            System.out.print(ans.get(0)[N * 2 - 1]);
        }
        else System.out.println(-1);
    }

    static void recursion(int[] arr, int idx) {
        if (idx == N) {
            ans.add(arr.clone());
            return;
        }

        int num = numList.get(idx);
        for (int i = 0; i < N * 2 - num - 1; i++) {
            if (arr[i] == -1 && arr[i + num + 1] == -1) {
                arr[i] = num;
                arr[i + num + 1] = num;
                recursion(arr, idx + 1);
                arr[i] = -1;
                arr[i + num + 1] = -1;
            }
        }
    }
}