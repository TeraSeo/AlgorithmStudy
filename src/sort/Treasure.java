package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Treasure {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        int[] numLists1 = new int[cnt];
        int[] numLists2 = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            numLists1[i] = sc.nextInt();
        }

        for (int i = 0; i < cnt; i++) {
            numLists2[i] = sc.nextInt();
        }

        Arrays.sort(numLists1);
        Arrays.sort(numLists2);

        int res = 0;
        for (int i = 0; i < numLists1.length; i++) {
            res += numLists1[i] * numLists2[numLists1.length - 1 - i];
        }

        System.out.println(res);
    }

}
