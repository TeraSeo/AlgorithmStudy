package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Rope {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < cnt; i++) {
            q.add(Integer.valueOf(br.readLine()));
        }

        int res = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int num = q.poll();
            res = Integer.max(res, num * (q.size() + 1));
        }
        System.out.println(res);
    }
}
