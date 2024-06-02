package programmers.level2;

public class PoolBall {

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = {};

        for (int i = 0; i < balls.length; i++) {
            int x;
            int y;
            if (Math.abs(balls[i][0] - startX) > Math.abs(balls[i][1] - startY)) {
                x = Math.abs(balls[i][0] - startX);
                if (Math.abs(startY - n / 2) >= Math.abs(balls[i][1] - n / 2)) {
                    if (startY > n / 2) {
                        y = Math.abs(n - startY) + Math.abs(n - balls[i][1]);
                    }
                    else {
                        y = startY + balls[i][1];
                    }
                }
                else {
                    if (balls[i][1] > n / 2) {
                        y = Math.abs(n - startY) + Math.abs(n - balls[i][1]);
                    }
                    else {
                        y = startY + balls[i][1];
                    }
                }
            }
            else {
                y = Math.abs(balls[i][1] - startY);
                if (Math.abs(startX - m / 2) >= Math.abs(balls[i][0] - m / 2)) {
                    if (startX > m / 2) {
                        x = Math.abs(m - startY) + Math.abs(m - balls[i][0]);
                    }
                    else {
                        x = startY + balls[i][0];
                    }
                }
                else {
                    if (balls[i][0] > m / 2) {
                        x = Math.abs(m - startX) + Math.abs(m - balls[i][0]);
                    }
                    else {
                        x = startX + balls[i][0];
                    }
                }
            }
            answer[i] = (int) (Math.pow(x, 2) + Math.pow(y, 2));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(10 - (double) 7 / 2);
    }
}
