package baekjoon.graph_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SafetyPlace {
    public static void main(String[] args) throws IOException {
        int ans = 1;
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[cnt][cnt];
        boolean[][] isVisited;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cnt; i++) {
            String[] split = br.readLine().split(" ");
            for (int l = 0; l < split.length; l++) {
                arr[i][l] = Integer.parseInt(split[l]);
                max = Math.max(max, arr[i][l]);
            }
        }

        for (int i = 1; i <= max; i++) {
            Queue<int[]> queue = new LinkedList<>();
            isVisited = new boolean[cnt][cnt];
            int current = 0;

            for (int x = 0; x < cnt; x++) {
                for (int y = 0; y < cnt; y++) {
                    if (!isVisited[x][y] && arr[x][y] > i) {
                        current++;
                        queue.add(new int[]{x,y});
                    }
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = poll[0] + dx[l];
                            int ny = poll[1] + dy[l];

                            if (nx >= 0 && nx < cnt && ny >= 0 && ny < cnt) {
                                if (!isVisited[nx][ny] && arr[nx][ny] > i) {
                                    isVisited[nx][ny] = true;
                                    queue.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }

                    ans = Math.max(ans, current);
                }
            }
        }

        System.out.println(ans);
    }
}