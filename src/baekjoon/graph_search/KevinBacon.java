package baekjoon.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KevinBacon {
    static ArrayList<Integer>[] arr;
    static int n, m;
    static int ans, min;
    static int[][] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        ans = 1;
        min = Integer.MAX_VALUE;

        arr = new ArrayList[n + 1];
        cnt = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            for (int l = i + 1; l <= n; l++) {
                int sum = cnt(i, l);
                cnt[i][l] = sum;
                cnt[l][i] = sum;
            }
        }

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int l = 1; l <= n; l++) {
                sum += cnt[i][l];
            }

            if (sum < min) {
                min = sum;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    static int cnt(int a, int b) {
        int[] array = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        isVisited[a] = true;
        while (true) {
            int poll = queue.poll();
            ArrayList<Integer> arrayList = arr[poll];
            for (int i = 0; i < arrayList.size(); i++) {
                int num = arrayList.get(i);
                if (!isVisited[num]) {
                    isVisited[num] = true;
                    array[num] = array[poll] + 1;
                    queue.add(num);
                }
            }

            if (queue.contains(b)) break;
        }

        return array[b];
    }
}