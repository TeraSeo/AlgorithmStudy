package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Baekjoon 1099번
public class UnknownSentence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int cnt = Integer.parseInt(br.readLine());

        int[] dp = new int[word.length() + 1];
        String[] words = new String[cnt];
        String[] splitWords;
        Arrays.fill(dp, Integer.MAX_VALUE - 51);

        for (int i = 0; i < cnt; i++) {
            words[i] = br.readLine();
        }

        dp[0] = 0;
        for (int i = 1; i <= word.length(); i++) {
            splitWords = new String[i];
            for (int j = 0; j < i; j++) {
                splitWords[j] = word.substring(j, i);
            }

            for (int j = 0; j < splitWords.length; j++) {
                for (int j2 = 0; j2 < cnt; j2++) {
                    if (!areFrequenciesEqual(getFrequency(splitWords[j]), getFrequency(words[j2]))) continue;

                    int minMove = countMinMove(splitWords[j], words[j2]);

                    if (j == 0) {
                        dp[i] = Math.min(minMove, dp[i]);
                        continue;
                    }

                    dp[i] = Math.min(dp[i], minMove + dp[j]);
                }
            }
        }

        System.out.println(dp[word.length()] == Integer.MAX_VALUE - 51 ? -1 : dp[word.length()]);
    }

    public static int countMinMove(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) cnt++;
        }
        return cnt;
    }

    public static int[] getFrequency(String w) {
        int[] freq = new int[26];
        for (char c : w.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    public static boolean areFrequenciesEqual(int[] freq1, int[] freq2) {
        return Arrays.equals(freq1, freq2);
    }
}