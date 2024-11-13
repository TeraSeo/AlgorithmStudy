package baekjoon.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeParent {
    static ArrayList<Integer>[] arr;
    static int[] parent;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        arr = new ArrayList[cnt + 1];
        parent = new int[cnt + 1];
        isVisited = new boolean[cnt + 1];

        for (int i = 1; i <= cnt; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < cnt - 1; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            arr[a].add(b);
            arr[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            ArrayList<Integer> arrayList = arr[poll];
            for (int i : arrayList) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    parent[i] = poll;
                    queue.add(i);
                }
            }
        }

        for (int i = 2; i <= cnt; i++) {
            System.out.println(parent[i]);
        }
    }
}
