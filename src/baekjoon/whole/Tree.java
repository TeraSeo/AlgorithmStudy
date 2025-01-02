package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tree {
    static Map<Integer, ArrayList<Integer>> map;
    static int root, removingNode;
    static int ans;

    public static void main(String[] args) throws IOException {
        map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            map.put(i, new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == - 1) {
                root = i;
            }
            else {
                ArrayList<Integer> arrayList = map.get(num);
                arrayList.add(i);
                map.put(num, arrayList);
            }
        }

        removingNode = Integer.parseInt(br.readLine());
        if (root != removingNode) {
            bfs();
        }
        System.out.println(ans);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> arrayList = map.get(root);

        for (int num : arrayList) {
            if (num != removingNode) {
                queue.add(num);
            }
            else {
                if (arrayList.size() == 1) ans++;
            }
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            ArrayList<Integer> polledArrayList = map.get(poll);
            if (polledArrayList.size() > 0) {
                for (int num : polledArrayList) {
                    if (num != removingNode) {
                        queue.add(num);
                    }
                    else {
                        if (polledArrayList.size() == 1) ans++;
                    }
                }
            }
            else {
                ans++;
            }
        }
    }
}