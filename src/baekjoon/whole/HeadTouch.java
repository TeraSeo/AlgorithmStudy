package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Baekjoon 1241번
public class HeadTouch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> numList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            numList.add(num);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        for (int i = 0; i < cnt; i++) {
            int num = numList.get(i);
            int numCnt = map.get(num) - 1;
            if (num != 1) {
                int sqrt = (int) Math.sqrt(num);
                for(int j = 1; j <= sqrt; j++){
                    if(num % j == 0){
                        if (map.containsKey(j)) {
                            numCnt += map.get(j);
                        }
                        if (num / j != j && j != 1){
                            if (map.containsKey(num / j)) {
                                numCnt += map.get(num / j);
                            }
                        }
                    }
                }
            }
            System.out.println(numCnt);
        }
    }
}
