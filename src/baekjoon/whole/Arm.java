package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        if (R.length() > L.length()) System.out.println(0);
        else {
            int ans = 0;
            for (int i = 0; i < L.length(); i++) {
                char c_L = L.charAt(i);

                if (c_L == '8') {
                    String s = L.substring(0, i);
                    s += "9";
                    for (int j = i + 1; j < L.length(); j++) {
                        s += "0";
                    }

                    if (Integer.parseInt(s) <= Integer.parseInt(R)) {
                        break;
                    }
                    else {
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
