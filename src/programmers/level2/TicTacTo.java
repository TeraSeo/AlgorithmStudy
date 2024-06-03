package programmers.level2;

public class TicTacTo {
    static String[][] boards;

    public int solution(String[] board) {

        boards = new String[3][3];
        for (int i = 0; i < 3; i++) {
            boards[i] = board[i].split("");
        }
        int oH = oneLineHorO();
        int oV = oneLineVerO();
        int oA = oneAccrossO();
        int xH = oneLineHorX();
        int xV = oneLineVerX();
        int xA = oneAccrossX();
        int oCnt = oCount();
        int xCnt = xCount();

        if (oH + oV + oA == 0 && xH + xV + xA == 0) {
            if (oCnt - xCnt == 1 || oCnt == xCnt) {
                return 1;
            }
        }
        else if (oH + oV + oA == 1 && xH + xV + xA == 0) {
            if (oCnt - 1 == xCnt) {
                return 1;
            }
        }
        else if (oH + oV + oA == 0 && xH + xV + xA == 1) {
            if (oCnt == xCnt) {
                return 1;
            }
        }
        else if (oH + oV + oA == 2 && xH + xV + xA == 0) {
            if (oCnt - 1 == xCnt) {
                return 1;
            }
        }

        return 0;
    }

    public int oCount() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 3; l++) {
                if (boards[i][l].equals("O")) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int xCount() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 3; l++) {
                if (boards[i][l].equals("X")) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int oneLineHorO() {
        int oneLineCnt = 0;
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int l = 0; l < 3; l++) {
                if (boards[i][l].equals("O")) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                oneLineCnt++;
            }
        }

        return oneLineCnt;
    }

    public int oneLineVerO() {
        int oneLineCnt = 0;

        if (boards[0][0].equals(boards[1][0]) && boards[1][0].equals(boards[2][0]) && boards[0][0].equals("O")) {
            oneLineCnt++;
        }
        if (boards[0][1].equals(boards[1][1]) && boards[1][1].equals(boards[2][1]) && boards[0][1].equals("O")) {
            oneLineCnt++;
        }
        if (boards[0][2].equals(boards[1][2]) && boards[1][2].equals(boards[2][2]) && boards[0][2].equals("O")) {
            oneLineCnt++;
        }

        return oneLineCnt;
    }

    public int oneAccrossO() {
        int oneLineCnt = 0;

        if (boards[0][0].equals(boards[1][1]) && boards[1][1].equals(boards[2][2]) && boards[0][0].equals("O")) {
            oneLineCnt++;
        }
        if (boards[0][2].equals(boards[1][1]) && boards[1][1].equals(boards[2][0]) && boards[0][2].equals("O")) {
            oneLineCnt++;
        }

        return oneLineCnt;
    }

    public int oneLineHorX() {
        int oneLineCnt = 0;

        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int l = 0; l < 3; l++) {
                if (boards[i][l].equals("X")) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                oneLineCnt++;
            }
        }

        return oneLineCnt;
    }

    public int oneLineVerX() {
        int oneLineCnt = 0;

        if (boards[0][0].equals(boards[1][0]) && boards[1][0].equals(boards[2][0]) && boards[0][0].equals("X")) {
            oneLineCnt++;
        }
        if (boards[0][1].equals(boards[1][1]) && boards[1][1].equals(boards[2][1]) && boards[0][1].equals("X")) {
            oneLineCnt++;
        }
        if (boards[0][2].equals(boards[1][2]) && boards[1][2].equals(boards[2][2]) && boards[0][2].equals("X")) {
            oneLineCnt++;
        }

        return oneLineCnt;
    }

    public int oneAccrossX() {
        int oneLineCnt = 0;

        if (boards[0][0].equals(boards[1][1]) && boards[1][1].equals(boards[2][2]) && boards[0][0].equals("X")) {
            oneLineCnt++;
        }
        if (boards[0][2].equals(boards[1][1]) && boards[1][1].equals(boards[2][0]) && boards[0][2].equals("X")) {
            oneLineCnt++;
        }

        return oneLineCnt;
    }
}
