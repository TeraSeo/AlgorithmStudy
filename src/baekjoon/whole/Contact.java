package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

// Baekjoon 1013번
public class Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            boolean isTrue = true;

            List<String> arrayList = new ArrayList<>();

            StringBuilder sb = new StringBuilder(br.readLine());

            int lastIdx = 0;
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.substring(j, j + 2).equals("01")) {
                    if (j == 0) {
                        lastIdx = j + 2;
                    }
                    else {
                        if (sb.charAt(j - 1) == '1') {
                            if (lastIdx != j) {
                                arrayList.add(sb.substring(lastIdx, j));
                            }
                            lastIdx = j + 2;

                        }
                    }
                }
            }
            if (lastIdx != sb.length()) {
                arrayList.add(sb.substring(lastIdx, sb.length()));
            }

            for (int j = 0; j < arrayList.size(); j++) {
                boolean isValid = checkIsValid(arrayList.get(j));
                if (!isValid) isTrue = false;
            }

            System.out.println(isTrue ? "YES" : "NO");
        }
    }

    public static boolean checkIsValid(String s) {
        String pattern = "(100+1+)+";
        return Pattern.matches(pattern, s);
    }
}
