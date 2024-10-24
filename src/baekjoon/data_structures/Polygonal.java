package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Polygonal {
    static int cnt;
    static int sum = 0;
    static ArrayList<int[]> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            String[] splits = s.split(" ");

            int a = Integer.parseInt(splits[0]);
            int b = Integer.parseInt(splits[1]);

            arrayList.add(new int[]{a, b});
        }

        arrayList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int highestIndex = getHighestIndex(arrayList);

        sum += arrayList.get(highestIndex)[1];
        leftRecursion(highestIndex);
        rightRecursion(highestIndex);

        System.out.println(sum);
    }

    static void leftRecursion(int index) {
        if (index - 1 == 0) {
            sum += (arrayList.get(index)[0] - arrayList.get(0)[0]) * arrayList.get(0)[1];
            return;
        }
        else if (index == 0) return;
        List<int[]> list = arrayList.subList(0, index);
        int highestIndex = getHighestIndex(list);
        int[] arr = list.get(highestIndex);
        int currentX = arrayList.get(index)[0];
        sum += (currentX - arr[0]) * arr[1];
        leftRecursion(highestIndex);
    }

    static void rightRecursion(int index) {
        if (index + 1 == cnt - 1) {
            sum += (arrayList.get(cnt - 1)[0] - arrayList.get(index)[0]) * arrayList.get(cnt - 1)[1];
            return;
        }
        else if (index == cnt - 1) return;
        List<int[]> list = arrayList.subList(index + 1, cnt);
        int highestIndex = getHighestIndex(list);
        int[] arr = list.get(highestIndex);
        int currentX = arrayList.get(index)[0];
        sum += (arr[0] - currentX) * arr[1];

        rightRecursion(highestIndex + index + 1);
    }

    static int getHighestIndex(List<int[]> arrayList) {
        int highestIndex = 0;
        int maxY = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)[1] > maxY) {
                maxY = arrayList.get(i)[1];
                highestIndex = i;
            }
        }
        return highestIndex;
    }
}
