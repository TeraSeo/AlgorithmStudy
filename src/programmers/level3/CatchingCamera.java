package programmers.level3;

import java.util.Arrays;

public class CatchingCamera {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] lastRange = {routes[0][0], routes[0][1]};
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] >= lastRange[0] && routes[i][0] <= lastRange[1]) {
                if (routes[i][0] > lastRange[0]) lastRange[0] = routes[i][0];
                if (routes[i][1] < lastRange[1]) lastRange[1] = routes[i][1];
            }
            else {
                answer++;
                lastRange[0] = routes[i][0];
                lastRange[1] = routes[i][1];
            }
        }

        return answer;
    }
}
