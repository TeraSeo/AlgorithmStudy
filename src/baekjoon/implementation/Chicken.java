package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Chicken {

    static int size;
    static int protectedNum;

    static List<Node> chickenList = new ArrayList<>();
    static List<Node> homeList = new ArrayList<>();
    static boolean[] chickenVisited;
    static int chickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        size = Integer.parseInt(xy[0]);
        protectedNum = Integer.parseInt(xy[1]);

        StringTokenizer st;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    homeList.add(new Node(i, j));
                }
                else if (val == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }

        chickenVisited = new boolean[chickenList.size()];

        calcDistance(0,0);
        System.out.println(chickenDistance);
    }

    static void calcDistance(int count, int idx) {

        if (count == protectedNum) {
            int total = 0;
            for (int i = 0; i < homeList.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++) {
                    if (chickenVisited[j] == true) {
                        int distance_x = Math.abs(homeList.get(i).x - chickenList.get(j).x);
                        int distance_y = Math.abs(homeList.get(i).y - chickenList.get(j).y);
                        min = Math.min(distance_x + distance_y, min);
                    }
                }
                total += min;
            }
            chickenDistance = Math.min(chickenDistance, total);
        }

        for (int i = idx; i < chickenVisited.length; i++) {
            if (chickenVisited[i] == false) {
                chickenVisited[i] = true;
                calcDistance(count + 1, i + 1);
                chickenVisited[i] = false;
            }
        }

    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
