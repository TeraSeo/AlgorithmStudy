package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Treasure {
    static int y_size;
    static int x_size;
    static String[][] arr;
    static boolean[][] isVisited;
    static int[][] cnt;
    static int[] d_x = new int[]{1,-1,0,0};
    static int[] d_y = new int[]{0,0,1,-1};
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        y_size = Integer.parseInt(split[0]);
        x_size = Integer.parseInt(split[1]);

        arr = new String[y_size][x_size];

        for (int i = 0; i < y_size; i++) {
            String[] s = br.readLine().split("");
            arr[i] = s;
        }

        for (int i = 0; i < y_size; i++) {
            for (int l = 0; l < x_size; l++) {
                if (arr[i][l].equals("L")) {
                    isVisited = new boolean[y_size][x_size];
                    cnt = new int[y_size][x_size];
                    bfs(l, i);
                }
            }
        }

        System.out.println(ans);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        isVisited[startY][startX] = true;
        cnt[startY][startX] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int n_x = d_x[i] + x;
                int n_y = d_y[i] + y;
                if (n_x >= 0 && n_x < x_size && n_y >= 0 && n_y < y_size && !isVisited[n_y][n_x] && arr[n_y][n_x].equals("L")) {
                    cnt[n_y][n_x] = cnt[y][x] + 1;
                    ans = Math.max(cnt[n_y][n_x], ans);
                    isVisited[n_y][n_x] = true;
                    queue.add(new int[]{n_x, n_y});
                }
            }
        }
    }
}
