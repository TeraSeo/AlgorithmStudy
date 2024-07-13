package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int last = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            String[] splits = s.split(" ");

            switch(splits[0]) {
                case "push":
                    last = Integer.valueOf(splits[1]);
                    queue.add(last);
                    break;
                case "pop":
                    if (queue.size() == 0) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(queue.poll());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.size() == 0) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (queue.size() == 0) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(queue.peek());
                    }
                    break;
                case "back":
                    if (queue.size() == 0) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(last);
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
