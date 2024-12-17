package baekjoon.whole;

import java.util.*;
import java.io.*;

public class Lie {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int ans = M;

        ArrayList<String> unknown = new ArrayList<>();
        ArrayList<ArrayList<String>> cases = new ArrayList<>();
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        boolean[] isTrue = new boolean[M];

        for (int i = 1; i <= N; i++) {
            map.put(String.valueOf(i), new ArrayList<>());
        }

        split = br.readLine().split(" ");
        int cnt = Integer.parseInt(split[0]);
        for (int i = 1; i <= cnt; i++) {
            unknown.add(split[i]);
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int peopleCnt = Integer.parseInt(split[0]);
            ArrayList<String> a_case = new ArrayList<>();
            for (int l = 1; l <= peopleCnt; l++) {
                a_case.add(split[l]);
                ArrayList<Integer> arrayList = map.get(split[l]);
                arrayList.add(i);
                map.put(split[l], arrayList);
            }
            cases.add(a_case);
        }

        Queue<String> queue = new LinkedList<>();
        for (String s : unknown) queue.add(s);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            ArrayList<Integer> arrayList = map.get(poll);
            for (int i = 0; i < arrayList.size(); i++) {
                if (!isTrue[arrayList.get(i)]) {
                    isTrue[arrayList.get(i)] = true;
                    ArrayList<String> a_case = cases.get(arrayList.get(i));
                    for (String c : a_case) queue.add(c);
                    ans--;
                }
            }
        }

        System.out.println(ans);
    }
}