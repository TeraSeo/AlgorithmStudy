package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baekjoon 1186번
public class RectangleColor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arrayList = new ArrayList<>();
        ArrayList<int[]> areaList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int[] arr = new int[]{x1, y1, x2, y2};
            arrayList.add(arr);
        }

        for (int i = N - 1; i >= 0; i--) {
            int[] arr1 = arrayList.get(i);
            if (i + 1 < N) {
                int area = 0;
                for (int j = i + 1; j < N; j++) {
                    int[] arr2 = arrayList.get(j);

                    int x1 = arr1[0];
                    int x2 = arr1[2];
                    int y1 = arr1[1];
                    int y2 = arr1[3];

                    int temp = (x2 - x1) * (y2 - y1);

                    if (arr1[0] > arr2[0] && arr1[2] > arr2[2] && arr1[0] < arr2[2]) {
                        x1 = arr1[0];
                        x2 = arr2[2];
                    }
                    if (arr1[0] < arr2[0] && arr1[2] > arr2[0] && arr1[2] < arr2[2]) {
                        x1 = arr2[0];
                        x2 = arr1[2];
                    }
                    if (arr1[1] > arr2[1] && arr1[3] > arr2[3] && arr1[1] < arr2[3]) {
                        y1 = arr1[1];
                        y2 = arr2[3];
                    }
                    if (arr1[1] < arr2[1] && arr1[3] > arr2[1] && arr1[3] < arr2[3]) {
                        y1 = arr2[1];
                        y2 = arr1[3];
                    }

                    area = Math.max(area, temp - (x2 - x1) * (y2 - y1));
                }

                System.out.println(i + 1 + " " + area);
                areaList.add(new int[]{i + 1, area});
            }
            else {
                System.out.println(i + 1 + " " + (arr1[2] - arr1[0]) * (arr1[3] - arr1[1]));
                areaList.add(new int[]{i + 1, (arr1[2] - arr1[0]) * (arr1[3] - arr1[1])});
            }
        }
        Collections.sort(areaList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            answer.add(areaList.get(i)[0]);
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K - 1; i++) {
            sb.append(answer.get(i) + " ");
        }
        sb.append(answer.get(K - 1));

        System.out.println(sb);
    }
}
