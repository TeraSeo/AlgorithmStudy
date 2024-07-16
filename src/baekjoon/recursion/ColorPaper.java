package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper {

    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        arr = new int[cnt][cnt];
        
        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int l = 0; l < cnt; l++) {
                int token = Integer.parseInt(st.nextToken());
                arr[i][l] = token;
            }
        }

        recursion(cnt, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void recursion(int width, int start_x, int start_y) {
        boolean isAllWhite = true;
        boolean isAllBlue = true;
        for (int i = 0; i < width; i++) {
            for (int l = 0; l < width; l++) {
                if (arr[start_y + i][start_x + l] == 1) isAllWhite = false;
                else isAllBlue = false;
            }
        }
        if (isAllWhite) {
            white += 1;
        }
        else if (isAllBlue) {
            blue += 1;
        }
        else {
            recursion(width / 2, start_x, start_y);
            recursion(width / 2, start_x + width / 2, start_y);
            recursion(width / 2, start_x, start_y + width / 2);
            recursion(width / 2, start_x + width / 2, start_y + width / 2);
        }
    }
}
