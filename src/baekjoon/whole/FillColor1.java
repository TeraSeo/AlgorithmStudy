package baekjoon.whole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1117번
public class FillColor1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        long W = Integer.parseInt(split[0]);
        long H = Integer.parseInt(split[1]);
        long f = Integer.parseInt(split[2]);
        long c = Integer.parseInt(split[3]);
        long x1 = Integer.parseInt(split[4]);
        long y1 = Integer.parseInt(split[5]);
        long x2 = Integer.parseInt(split[6]);
        long y2 = Integer.parseInt(split[7]);

        long foldedWidth = Math.min(f, (W - f));
        long overlapStart = x1;
        if (x1 >= foldedWidth) {
            overlapStart = foldedWidth;
        }
        long overlapEnd = Math.min(foldedWidth, x2);
        long overlapWidth = Math.max(0, overlapEnd - overlapStart);

        long area = W * H;
        long xDiff = x2 - x1;
        long yDiff = y2 - y1;

        long paintedArea = xDiff * yDiff * (c + 1);
        long doublePaintedArea = overlapWidth * yDiff  * (c + 1);

        System.out.println(area - (paintedArea + doublePaintedArea));
    }
}
