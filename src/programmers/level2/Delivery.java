package programmers.level2;

import java.util.*;

public class Delivery {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> delvs = new Stack<>();
        Stack<Integer> picks = new Stack<>();
        for (int i = 0; i < n; i++) {
            delvs.add(deliveries[i]);
            picks.add(pickups[i]);
        }

        while (delvs.size() > 0 && picks.size() > 0) {
            int avail_delv = cap;
            int cur_cap = 0;
            int far = 0;
            while (avail_delv != 0) {
                int delv;
                if (delvs.size() > 0) {
                    
                }
                if (delvs.size() == 0) {
                    delv = 0;
                }
                else {
                    delv = delvs.pop();
                }

                if (delv != 0) {
                    if (avail_delv > 0) {
                        far = Integer.max(delvs.size() + 1, far);
                        if (avail_delv > delv) {
                            avail_delv -= delv;
                        }
                        else {
                            delv -= avail_delv;
                            cur_cap -= avail_delv;
                            delvs.add(delv);
                            avail_delv = 0;
                        }
                    }
                }

                if (delvs.size() == 0) break;
            }

            while (cur_cap == cap) {
                int pick;
                if (picks.size() > 0) {
                    while (picks.peek() == 0) {
                        picks.pop();
                    }
                }
                if (picks.size() == 0) {
                    pick = 0;
                }
                else {
                    pick = picks.pop();
                }

                if (pick != 0) {
                    if (cur_cap < cap) {
                        far = Integer.max(picks.size() + 1, far);
                        int remainCap = cap - cur_cap;
                        if (pick - remainCap > 0) {
                            pick -= remainCap;
                            cur_cap = cap;
                            picks.add(pick);
                        }
                        else {
                            cur_cap += pick;
                        }
                    }
                }

                if (picks.size() == 0) break;
            }

            answer += far;
            System.out.println("ans: " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        long solution = solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
        System.out.println(solution);
    }

}
