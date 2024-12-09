package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baekjoon 1034번
public class Lamp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<ArrayList<Integer>, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(split[j]);
                if (n == 0) arrayList.add(j);
            }

            if (map.containsKey(arrayList)) map.put(arrayList, map.get(arrayList) + 1);
            else map.put(arrayList, 1);
        }

        List<ArrayList<Integer>> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        int k = Integer.parseInt(br.readLine());
        List<Integer> availableReversingTimes = new ArrayList<>();
        if (k > M) {
            while (k > M) {
                k -= 2;
            }
        }

        while (k >= 0) {
            availableReversingTimes.add(k);
            k-= 2;
        }

        int ans = 0;
        for (ArrayList<Integer> key : keySet) {
            if (availableReversingTimes.contains(key.size())) ans = map.get(key);
        }
        System.out.println(ans);
    }
}
