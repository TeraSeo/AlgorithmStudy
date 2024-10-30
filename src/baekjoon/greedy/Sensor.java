package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Sensor {
    public static void main(String[] args) throws IOException {
        int ans = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensors = new int[n];
        int[] signals = new int[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);

        for (int i = 0; i < n - 1; i++) {
            signals[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(signals);

        for (int i = 0; i < n - k; i++) {
            ans += signals[i];
        }

        System.out.println(ans);
    }
}
