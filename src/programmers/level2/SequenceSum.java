package programmers.level2;

public class SequenceSum {

    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int left = 0;
        int right = N;
        int sum = 0;
        for (int i = 0, l = 0; i < N; i++) {
            while (l < N && sum < k) {
                sum += sequence[l++];
            }

            if (right - left > l - i - 1) {
                left = i;
                right = l - 1;
            }
        }

        int[] answer = {left, right};
        return answer;
    }

}
