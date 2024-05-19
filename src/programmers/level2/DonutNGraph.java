package programmers.level2;

import java.util.*;

public class DonutNGraph {
    public static int[] solution(int[][] edges) {
        int[] answer = {};

        Map<Integer, int[]> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!graph.containsKey(edges[i][0])) {
                graph.put(edges[i][0], new int[]{0, 0});
            }
            if (!graph.containsKey(edges[i][1])) {
                graph.put(edges[i][1], new int[]{0, 0});
            }
            graph.get(edges[i][0])[0] += 1;
            graph.get(edges[i][1])[1] += 1;
        }

        int[] cnts;
        for (int key: graph.keySet()) {
            cnts = graph.get(key);
            if (cnts[0] >= 2 && cnts[1] == 0) {
                answer[0] = key;
            }
            else if (cnts[0] == 0 && cnts[1] > 0) {
                answer[2]++;
            }
            else if (cnts[0] >= 2 && cnts[1] >= 2) {
                answer[3]++;
            }
        }
        answer[1] = graph.get(answer[0])[0] - answer[2] - answer[3];

        return answer;
    }

}
