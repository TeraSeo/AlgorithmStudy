package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class laboratory {

    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static int originalMap[][];
    static int n, m;
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        n = Integer.parseInt(xy[0]);
        m = Integer.parseInt(xy[1]);
        originalMap = new int[n][m];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);

    }

    static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(wallCnt + 1);
                    originalMap[i][j] = 0;
                }
            }
        }

    }

    static void bfs() {

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] == 2) {
                    q.add(new Node(j, i));
                }
            }
        }

        int copyMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = originalMap[i].clone();
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (copyMap[ny][nx] == 0) {
                        q.add(new Node(nx, ny));
                        copyMap[ny][nx] = 2;
                    }
                }
            }
        }

        calcSafeZone(copyMap);
    }

    static void calcSafeZone(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        if (maxSafeZone < cnt) {
            maxSafeZone = cnt;
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
