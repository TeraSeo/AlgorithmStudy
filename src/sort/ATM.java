package sort;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] nums = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                res += nums[j];
            }
        }

        System.out.println(res);

    }
    
}
