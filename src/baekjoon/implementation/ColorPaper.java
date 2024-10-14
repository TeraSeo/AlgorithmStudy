package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorPaper {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[101][101];
        int minX = 110;
        int maxX = 0;
        int minY = 110;
        int maxY = 0;

        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String s = br.readLine();
            String[] splits = s.split(" ");
            int a = Integer.parseInt(splits[0]);
            int b = Integer.parseInt(splits[1]);

            minX = Math.min(minX, a);
            maxX = Math.max(maxX, a + 10);
            minY = Math.min(minY, b);
            maxY = Math.max(maxY, b + 10);

            for (int x = a; x < a + 10; x++) {
                for (int y = b; y < b + 10; y++) {
                    if (arr[x][y] != 1) arr[x][y] = 1;
                }
            }
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                sum += arr[x][y];
            }
        }

        System.out.println(sum);
    }
}
