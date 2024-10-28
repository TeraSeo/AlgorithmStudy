package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class WordMath {
    public static void main(String[] args) throws IOException {
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            for (int l = 0; l < s.length(); l++) {
                int num = (int) Math.pow(10, s.length() - l - 1);
                arr[(int) s.charAt(l) - 65] += num;
            }
        }

        Arrays.sort(arr);

        int index = 9;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                sum += arr[i] * index;
                index--;
            }
        }

        System.out.println(sum);
    }
}