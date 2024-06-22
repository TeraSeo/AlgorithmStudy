package programmers.level2;

import java.math.BigInteger;

public class bits {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder sb = new StringBuilder("");
            String binary = Long.toBinaryString(numbers[i]);
            String[] split = binary.split("");
            if (binary.contains("0")) {
                for (int l = split.length - 1; l >= 0; l--) {
                    if (split[l].equals("0")) {
                        split[l] = "1";
                        if (l + 1 < split.length) {
                            split[l + 1] = "0";
                        }
                        break;
                    }
                }
            }
            else {
                sb.append("1");
                split[0] = "0";
            }

            for (int l = 0; l < split.length; l++) {
                sb.append(split[l]);
            }

            answer[i] = new BigInteger(sb.toString(), 2).longValue();
        }

        return answer;
    }

}
