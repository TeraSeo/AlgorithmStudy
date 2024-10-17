package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FindPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] counts = br.readLine().split(" ");
        int cnt1 = Integer.parseInt(counts[0]);
        int cnt2 = Integer.parseInt(counts[1]);

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < cnt1; i++) {
            String[] splits = br.readLine().split(" ");
            map.put(splits[0], splits[1]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cnt2; i++) {
            String address = br.readLine();
            result.append(map.get(address) + "\n");
        }

        System.out.println(result);
    }
}