package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baekjoon 1092 번
public class Ship {
    public static void main(String[] args) throws IOException {
        int[] weighArr;
        ArrayList<Integer> boxArrayList = new ArrayList<>();
        int max_weigh = 0;
        int max_box = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer weighs = new StringTokenizer(br.readLine());
        weighArr = new int[N];

        for (int i = 0; i < N; i++) {
            String weigh = weighs.nextToken();
            weighArr[i] = Integer.valueOf(weigh);
            max_weigh = Integer.max(weighArr[i], max_weigh);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer boxes = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            String box = boxes.nextToken();
            boxArrayList.add(Integer.valueOf(box));
            max_box = Integer.max(Integer.valueOf(box), max_box);
        }

        Arrays.sort(weighArr);
        Collections.sort(boxArrayList);

        if (max_weigh >= max_box) {
            int cnt = 0;
            while (!boxArrayList.isEmpty()) {
                cnt++;
                for (int i = 0; i < N; i++) {
                    int weigh = weighArr[i];
                    for (int j = boxArrayList.size() - 1; j >= 0; j--) {
                        int box = boxArrayList.get(j);
                        if (weigh >= box) {
                            boxArrayList.remove(j);
                            break;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
        else {
            System.out.println(-1);
        }
    }
}