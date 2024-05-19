package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apartment {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int[][] res = new int[15][15];

        for (int i = 0; i < 15; i++) {
            res[i][1] = 1;
            res[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                res[i][j] = res[i][j - 1] + res[i - 1][j];
            }
        }

        for (int i = 0; i < cnt; i++) {
            int floor = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());

            System.out.println(res[floor][ho]);

        }
    }

}
