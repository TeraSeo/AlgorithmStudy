package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class AC {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque;

        for (int i = 0; i < cnt; i++) {

            String[] funcArr = br.readLine().split("");
            int size = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] split = s.substring(1, s.length() - 1).split(",");
            deque = new ArrayDeque<>();
            for (int j = 0; j < size; j++) {
                deque.add(Integer.valueOf(split[j]));
            }

            AC(deque, funcArr);
        }

        System.out.println(sb.toString());

    }

    static void AC(ArrayDeque<Integer> deque, String[] funcArr) {
        boolean isFront = true;
        for (int i = 0; i < funcArr.length; i++) {
            if (funcArr[i].equals("R")) {
                isFront = !isFront;
            }
            else {
                if (deque.size() == 0) {
                    sb.append("error\n");
                    return;
                }
                else {
                    if (isFront) {
                        deque.pollFirst();
                    }
                    else {
                        deque.pollLast();
                    }
                }
            }
        }

        if (deque.size() == 0) {
            sb.append("[]\n");
        }
        else {
            sb.append("[");
            if (isFront) {
                while (deque.size() != 1) {
                    sb.append(deque.pollFirst() + ",");
                }
                sb.append(deque.pollFirst() + "]\n");
            }
            else {
                while (deque.size() != 1) {
                    sb.append(deque.pollLast() + ",");
                }
                sb.append(deque.pollLast() + "]\n");
            }
        }
    }
}
