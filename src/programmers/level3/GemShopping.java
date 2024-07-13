package programmers.level3;

import java.util.HashSet;
import java.util.Set;

public class GemShopping {

    public static int[] solution(String[] gems) {
        int[] answer = {};
        Set<String> gemList = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            gemList.add(gems[i]);
        }

        for (String gem: gemList) {
            System.out.println(gem);
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
    }
}
