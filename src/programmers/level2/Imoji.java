package programmers.level2;

import java.util.Arrays;

public class Imoji {

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        Arrays.sort(users, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        return answer;
    }

    public static void main(String[] args) {
        boolean is = true;
        while (is) {
            for (int i = 0; i < 100; i++) {
                if (i == 10) {
                    is = false;
                    break;
                }
                System.out.println(i);
            }
        }
    }

}
