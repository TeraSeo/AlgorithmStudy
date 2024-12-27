package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CardManagment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> joker = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                arrayList1.add(Integer.valueOf(split[j]));
                if (!split[j].equals("0")) {
                    cnt++;
                }
            }
            if (cnt < 2) {
                arrayList.add(arrayList1);
            }
            else {
                joker.add(arrayList1);
            }
        }

        for (int a = 0; a < M; a++) {
            int cnt = 0;
            for (int b = 0; b < arrayList.size(); b++) {
                ArrayList<Integer> arrayList1 = arrayList.get(b);
                if (arrayList1.get(a) != 0) cnt++;
            }
            if (cnt > 1) ans += cnt - 1;
        }

        ans += joker.size() - 1;
        if (ans == - 1) System.out.println(0);
        else System.out.println(ans);
    }
}