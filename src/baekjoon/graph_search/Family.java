package baekjoon.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Family {
    static ArrayList<Integer>[] arr;
    static boolean[] isVisited;
    static int[] cnt_arr;
    static int a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        cnt_arr = new int[n + 1];

        String[] split = br.readLine().split(" ");
        a = Integer.parseInt(split[0]);
        b = Integer.parseInt(split[1]);

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < cnt; i++) {
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        isVisited[a] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            ArrayList<Integer> arrayList = arr[poll];
            for (int i : arrayList) {
                if (!isVisited[i]) {
                    queue.add(i);
                    cnt_arr[i] = cnt_arr[poll] + 1;
                    isVisited[i] = true;
                }
            }
        }

        if (cnt_arr[b] == 0) System.out.println(-1);
        else System.out.println(cnt_arr[b]);
    }
}
