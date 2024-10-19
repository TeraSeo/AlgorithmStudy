package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseWord2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String[] splits = text.split("");

        Stack<String> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        boolean isOnTag = false;

        for (int i = 0; i < splits.length; i++) {
            if (splits[i].equals("<")) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append("<");
                isOnTag = true;
            }
            else if (splits[i].equals(">")) {
                sb.append(">");
                isOnTag = false;
            }
            else if (splits[i].equals(" ")) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            else {
                if (isOnTag) {
                    sb.append(splits[i]);
                }
                else {
                    stack.add(splits[i]);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
