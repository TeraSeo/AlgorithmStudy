package baekjoon.brute_force;

import java.io.*;

public class DateCalc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int E = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);
        int M = Integer.parseInt(split[2]);

        int e = 1;
        int s = 1;
        int m = 1;

        int cnt = 1;

        while (E != e || S != s || M != m){
            cnt++;
            e++;
            s++;
            m++;
            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;
        }

        System.out.println(cnt);
    }
}
