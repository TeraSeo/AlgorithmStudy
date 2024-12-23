package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MovePiece {

    static ArrayList<int[]> arrayList = new ArrayList<>();
    static int[][] temp = new int[5][5];
    static String[][] arr = new String[5][5];
    static boolean[][] isVisited;
    static boolean[][] isUsed;
    static int[] d_x = new int[]{1, -1, 0, 0};
    static int[] d_y = new int[]{0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                if (split[j].equals("*")) {
                    arrayList.add(new int[]{j, i});
                }
            }
            arr[i] = split;
        }

        bfs(0, 0);

        System.out.println(min);
    }

    static void bfs(int idx, int count) {
        if (count == arrayList.size()) {
            boolean isLinked = checkIsLinked();
            if (isLinked) {
                int minMove = getMinMove();
                min = Math.min(min, minMove);
            }
            return;
        }

        if (idx == 25) {
            return;
        }

        int a = idx / 5;
        int b = idx % 5;

        temp[a][b] = 1;
        bfs(idx + 1, count + 1);

        temp[a][b] = 0;
        bfs(idx + 1, count);
    }

    static boolean checkIsLinked() {
        isVisited = new boolean[5][5];

        int a = 0;
        int b = 0;
        int cnt = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (temp[i][j] == 1) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        isVisited[a][b] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int n_x = x + d_x[i];
                int n_y = y + d_y[i];

                if (n_x >= 0 && n_x < 5 && n_y >= 0 && n_y < 5) {
                    if (!isVisited[n_x][n_y] && temp[n_x][n_y] == 1) {
                        isVisited[n_x][n_y] = true;
                        queue.add(new int[]{n_x, n_y});
                        cnt++;
                    }
                }
            }
        }

        if (cnt == arrayList.size()) return true;
        return false;
    }

    static int getMinMove() {
        isUsed = new boolean[5][5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                if (arr[i][j].equals("*")) sum += getDist(i, j);
                if (sum >= min) return sum;
            }
        }
        return sum;
    }

    static int getDist(int a, int b) {
        isVisited = new boolean[5][5];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        isVisited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            if (!isUsed[x][y] && temp[x][y] == 1) {
                isUsed[x][y] = true;
                return Math.abs(x - a) + Math.abs(y - b);
            }

            for (int i = 0; i < 4; i++) {
                int n_x = x + d_x[i];
                int n_y = y + d_y[i];

                if (n_x >= 0 && n_x < 5 && n_y >= 0 && n_y < 5) {
                    if (!isVisited[n_x][n_y] && !isUsed[n_x][n_y]) {
                        isVisited[n_x][n_y] = true;
                        queue.add(new int[]{n_x, n_y});
                    }
                }
            }
        }
        return 1111111111;
    }
}
