package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakePW {

    static int L, C;
    static String[] alphabet, pwd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        L = Integer.parseInt(arr[0]);
        C = Integer.parseInt(arr[1]);

        pwd = new String[L];
        alphabet = br.readLine().split(" ");
        Arrays.sort(alphabet);

        makePw(0, 0);
    }

    static void makePw(int len, int start) {
        if (len >= L) {
            if (check()) {
                for (String p : pwd) System.out.print(p);
                System.out.println();
            }
            return;
        }
        for (int i = start; i < C; i++) {
            pwd[len] = alphabet[i];
            makePw(len + 1, i + 1);
        }
    }

    static boolean check() {
        int c = 0;
        int v = 0;
        for (int i = 0; i < pwd.length; i++) {
            if (pwd[i].equals("a")||pwd[i].equals("e")||pwd[i].equals("i")||pwd[i].equals("o")||pwd[i].equals("u")) v++;
            else c++;
        }
        if (c >= 2 && v >= 1) return true;
        return false;
    }
}
