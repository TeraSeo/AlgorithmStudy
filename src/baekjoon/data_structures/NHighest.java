package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class NHighest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] splits = s.split(" ");
            for (int l = 0; l < n; l++) {
                queue.add(Integer.valueOf(splits[l]));
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.println(queue.poll());
            }
            else {
                queue.poll();
            }
        }
    }
}
