package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GroupWordCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            String[] split = s.split("");

            boolean isPlus = true;
            List<String> arrayList = new ArrayList<>();
            String last = "";
            for (int l = 0; l < split.length; l++) {
                if (!arrayList.contains(split[l])) {
                    last = split[l];
                    arrayList.add(split[l]);
                }
                else {
                    if (!split[l].equals(last)) {
                        isPlus = false;
                    }
                }
            }

            if (isPlus) res++;
        }

        System.out.println(res);
    }
}
