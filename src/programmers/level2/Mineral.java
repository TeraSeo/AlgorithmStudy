package programmers.level2;
import java.util.*;

public class Mineral {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] arr;
        int picksCnt = picks[0] + picks[1] + picks[2]; // 곡괭이 개수
        int pickTimes = minerals.length / 5; // 곡괭이 사용 횟수
        if (minerals.length % 5 != 0) {
            pickTimes++;
        }
        if (picksCnt >= pickTimes) {
            arr = new int[pickTimes][2];
            for (int i = 0; i < pickTimes; i++) {
                int sum = 0;
                if (i == pickTimes - 1) {
                    if (minerals.length % 5 != 0) {
                        sum = calcSum(i, minerals.length % 5, minerals);
                    }
                    else {
                        sum = calcSum(i, 5, minerals);
                    }
                }
                else {
                    sum = calcSum(i, 5, minerals);
                }

                arr[i]= new int[]{i, sum};
            }
        }
        else {
            arr = new int[picksCnt][2];
            for (int i = 0; i < picksCnt; i++) {
                int sum = 0;
                sum = calcSum(i, 5, minerals);
                arr[i] = new int[]{i, sum};
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        return answer;
    }

    int calcSum(int i, int l, String[] minerals) {
        int sum = 0;
        for (int x = 0; x < l; x++) {
            switch (minerals[i * 5 + x]) {
                case "diamond":
                    sum += 25;
                    break;
                case "iron":
                    sum += 5;
                    break;
                case "stone":
                    sum += 1;
                    break;
                default:
                    break;
            }
        }

        return sum;
    }

}
