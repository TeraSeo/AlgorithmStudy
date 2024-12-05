package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1058번
public class Friend {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        char[][] friends = new char[cnt][cnt];

        for (int i = 0; i < cnt; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for (int i = 0; i < cnt; i++) {
            boolean[] isTwoFriends = new boolean[cnt];

            for (int j = 0; j < cnt; j++) {
                if (friends[i][j] == 'Y') {
                    isTwoFriends[j] = true;

                    for (int k = 0; k < cnt; k++) {
                        if (friends[j][k] == 'Y' && i != k) isTwoFriends[k] = true;
                    }
                }
            }

            int friendsCnt = 0;
            for (int j = 0; j < cnt; j++) {
                if (isTwoFriends[j]) friendsCnt++;
            }

            max = Math.max(max, friendsCnt);
        }

        System.out.println(max);
    }
}
