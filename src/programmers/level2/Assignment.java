package programmers.level2;
import java.util.*;

public class Assignment {

    public String[] solution(String[][] plans) {
        Arrays.sort(plans, new Comparator<String[]>() {

            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String field1 = entry1[1];
                final String field2 = entry2[1];
                return field1.compareTo(field2);
            }
        });

        Stack<String[]> planStack = new Stack<>();
        String[] answer = new String[plans.length];

        int idx = 0;
        for (int i = 0; i < plans.length - 1; i++) {
            String[] split1 = plans[i][1].split(":");
            String[] split2 = plans[i + 1][1].split(":");

            int diff = calcTimeDiff(split1, split2);
            int time = Integer.parseInt(plans[i][2]);
            int spareTime = diff - time;
            if (spareTime >= 0) {
                answer[idx++] = plans[i][0];
                while (spareTime > 0 && planStack.size() > 0) {
                    String[] s = planStack.pop();
                    time = Integer.parseInt(s[2]);
                    if (time <= spareTime) {
                        spareTime -= time;
                        answer[idx++] = s[0];
                    }
                    else {
                        time -= spareTime;
                        spareTime = 0;
                        s[2] = String.valueOf(time);
                        planStack.add(s);
                    }
                }
            }
            else {
                time -= diff;
                plans[i][2] = String.valueOf(time);
                planStack.add(plans[i]);
            }
        }

        answer[idx++] = plans[plans.length - 1][0];
        while (planStack.size() > 0) {
            String[] s = planStack.pop();
            answer[idx++] = s[0];
        }

        return answer;
    }

    int calcTimeDiff(String[] split1, String[] split2) {
        int hourDiff = Integer.valueOf(split2[0]) - Integer.valueOf(split1[0]);
        int minDiff = Integer.valueOf(split2[1]) - Integer.valueOf(split1[1]);

        return hourDiff * 60 + minDiff;
    }
}
