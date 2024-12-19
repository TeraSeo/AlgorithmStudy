package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> wordsCounts = new ArrayList<>();

        while (true) {
            String s = br.readLine();
            if (s.equals("-")) break;
            char[] chars = s.toCharArray();
            int[] wordCount = getWordCount(chars);
            wordsCounts.add(wordCount);
        }

        while (true) {
            String s = br.readLine();
            if (s.equals("#")) break;

            int[] answerCount = new int[26];
            char[] chars = s.toCharArray();
            int[] puzzleCount = getWordCount(chars);

            for (int i = 0; i < wordsCounts.size(); i++) {
                int[] wordCount = wordsCounts.get(i);
                boolean isTrue = checkIsTrue(wordCount, puzzleCount);
                if (isTrue) {
                    for (int j = 0; j < wordCount.length; j++) {
                        if (wordCount[j] != 0) answerCount[j]++;
                    }
                }
            }

            List<Character> characterList = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (!characterList.contains(chars[i])) {
                    characterList.add(chars[i]);
                    answerCount[chars[i] - 'A']++;
                }
            }

            findMinMaxKeys(answerCount);
        }
    }

    public static int[] getWordCount(char[] chars) {
        int[] arr = new int[26];
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'A']++;
        }
        return arr;
    }

    public static boolean checkIsTrue(int[] wordCount1, int[] wordCount2) {
        for (int i = 0; i < 26; i++) {
            if (wordCount1[i] > wordCount2[i]) return false;
        }
        return true;
    }

    public static void findMinMaxKeys(int[] answer) {
        List<Character> minKeys = new ArrayList<>();
        List<Character> maxKeys = new ArrayList<>();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++) {
            int value = answer[i];

            if (value < minValue && value > 0) {
                minValue = value;
                minKeys.clear();
                minKeys.add((char) ('A' + i));
            }
            else if (value == minValue) minKeys.add((char) ('A' + i));

            if (value > maxValue) {
                maxValue = value;
                maxKeys.clear();
                maxKeys.add((char) ('A' + i));
            }
            else if (value == maxValue) maxKeys.add((char) ('A' + i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minKeys.size(); i++) {
            sb.append(minKeys.get(i));
        }
        sb.append(" ").append(minValue - 1).append(" ");

        for (int i = 0; i < maxKeys.size(); i++) {
            sb.append(maxKeys.get(i));
        }
        sb.append(" ").append(maxValue - 1);

        System.out.println(sb);
    }
}
