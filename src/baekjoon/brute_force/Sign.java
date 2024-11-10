package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        boolean isLeftStart = true;
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (split[0].equals("<")) isLeftStart = false;

        String temp = split[0];
        int sign_cnt = 1;
        for (int i = 1; i < cnt; i++) {
            if (temp.equals(split[i])) sign_cnt++;
            else {
                arrayList.add(sign_cnt);
                temp = split[i];
                sign_cnt = 1;
            }
        }
        arrayList.add(sign_cnt);

        boolean isCurrentLeft = isLeftStart;
        StringBuilder maxBuilder = new StringBuilder();
        List<Integer> num = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < arrayList.size(); i++) {
            if (isCurrentLeft) {
                int n = arrayList.get(i);
                if (i != 0 && i != arrayList.size() - 1) n -= 1;
                else if (arrayList.size() == 1) n += 1;
                for (int l = 0; l < n; l++) {
                    maxBuilder.append(num.remove(num.size() - 1));
                }
                isCurrentLeft = false;
            }
            else {
                int n = arrayList.get(i);
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < n + 1; l++) {
                    sb.append(num.remove(num.size() - 1));
                }
                maxBuilder.append(sb.reverse());
                isCurrentLeft = true;
            }
        }

        isCurrentLeft = isLeftStart;
        StringBuilder minBuilder = new StringBuilder();
        num = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < arrayList.size(); i++) {
            if (isCurrentLeft) {
                int n = arrayList.get(i);
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < n + 1; l++) {
                    sb.append(num.remove(0));
                }
                minBuilder.append(sb.reverse());
                isCurrentLeft = false;
            }
            else {
                int n = arrayList.get(i);
                if (i != 0 && i != arrayList.size() - 1) n -= 1;
                else if (arrayList.size() == 1) n += 1;
                for (int l = 0; l < n; l++) {
                    minBuilder.append(num.remove(0));
                }
                isCurrentLeft = true;
            }
        }

        System.out.println(maxBuilder);
        System.out.println(minBuilder);
    }
}
