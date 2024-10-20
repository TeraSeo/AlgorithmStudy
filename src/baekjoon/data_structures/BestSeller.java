package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BestSeller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
                arrayList.add(s);
            }
        }

        Collections.sort(arrayList);
        String res = "";
        int max = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            String s = arrayList.get(i);
            if (max < map.get(s)) {
                max = map.get(s);
                res = s;
            }
        }

        System.out.println(res);
    }
}
