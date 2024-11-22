package baekjoon.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class NightMovement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        for (int i = 0; i < cnt; i++) {
            int l = Integer.parseInt(br.readLine());
            String[] split1 = br.readLine().split(" ");
            int x1 = Integer.parseInt(split1[0]);
            int y1 = Integer.parseInt(split1[1]);

            String[] split2 = br.readLine().split(" ");
            int x2 = Integer.parseInt(split2[0]);
            int y2 = Integer.parseInt(split2[1]);

            int[][] arr = new int[l][l];
            boolean[][] isVisited = new boolean[l][l];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x1, y1});
            isVisited[x1][y1] = true;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = poll[0] + dx[j];
                    int ny = poll[1] + dy[j];

                    if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                        if (!isVisited[nx][ny]) {
                            isVisited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                            arr[nx][ny] = arr[poll[0]][poll[1]] + 1;
                        }
                    }
                }

                if (queue.contains(new int[]{x2, y2})) {
                    break;
                }
            }

            System.out.println(arr[x2][y2]);
        }
    }
}
