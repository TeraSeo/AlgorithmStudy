package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Connector {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> wordList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();;
            if (!wordList.contains(word)) {
                wordList.add(word);
            }
        }

        Collections.sort(wordList);

        ArrayList<String> ans = new ArrayList<>();
        for (int i = wordList.size() - 1; i >= 0; i--) {
            boolean isContained = false;

            String word = wordList.get(i);
            for (int j = 0; j < ans.size(); j++) {
                String ansWord = ans.get(j);
                if (ansWord.length() >= word.length()) {
                    String subWord = ansWord.substring(0, word.length());
                    if (subWord.equals(word)) {
                        isContained = true;
                    }
                }
            }

            if (!isContained) ans.add(word);
        }

        System.out.println(ans.size());
    }
}
