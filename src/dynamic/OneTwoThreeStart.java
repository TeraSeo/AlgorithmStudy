package dynamic;

import java.util.Scanner;

public class OneTwoThreeStart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        int[] numLists = new int[cnt];

        int max = 0;
        for (int i = 0; i < cnt; i++) {
            numLists[i] = sc.nextInt();
            if (numLists[i] > max) {
                max = numLists[i];
            }
        }

        int[] res = new int[max];
        res[0] = 1;
        res[1] = 2;
        res[2] = 4;

        for (int i = 3; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];
        }

        for (int i = 0; i < numLists.length; i++) {
            System.out.println(res[numLists[i] - 1]);
        }
    }


}
