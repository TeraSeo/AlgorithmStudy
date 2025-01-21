package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Baekjoon 1107번
public class RemoteController {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> availableNumList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int minDigit = 10;
        int minOver0Digit = 10;
        int maxDigit = -1;

        for (int i = 0; i < 10; i++)  {
            availableNumList.add(i);
        }

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                availableNumList.remove(Integer.valueOf(st.nextToken()));
            }
        }

        for (int i = 0; i < availableNumList.size(); i++) {
            int num = availableNumList.get(i);
            minDigit = Math.min(minDigit, num);
            maxDigit = Math.max(maxDigit, num);
            if (num != 0) minOver0Digit = Math.min(minOver0Digit, num);
        }

        ArrayList<String> combinedNumList = new ArrayList<>();
        for (int i = 0; i < availableNumList.size(); i++) combinedNumList.add(String.valueOf(availableNumList.get(i)));
        int ans = Math.abs(N - 100);
        if (M == 10) {
            System.out.println(ans);
            return;
        }

        for (int i = 1; i < String.valueOf(N).length(); i++) {
            ArrayList<String> tempList = new ArrayList<>();
            for (String combinedNum : combinedNumList) {
                for (int j = 0; j < availableNumList.size(); j++) {
                    tempList.add(combinedNum + availableNumList.get(j));
                }
            }

            combinedNumList = tempList;
        }

        String overDigitNum = String.valueOf(minOver0Digit);
        for (int i = 0; i < String.valueOf(N).length(); i++) {
            overDigitNum += minDigit;
        }
        combinedNumList.add(overDigitNum);

        String underDigitNum = "";
        for (int i = 0; i < String.valueOf(N).length() - 1; i++) {
            underDigitNum += maxDigit;
        }
        if (underDigitNum.length() > 0) combinedNumList.add(underDigitNum);

        for (String combinedNum : combinedNumList) {
            int num = Integer.parseInt(combinedNum);
            ans = Math.min(ans, String.valueOf(num).length() + Math.abs(N - num));
        }

        System.out.println(ans);
    }
}