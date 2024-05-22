package programmers.level2;

import java.util.*;

class AnalogueClock {

    static class Time {
        int h, m, s;

        Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }

        Time(int seconds) {
            this.h = seconds / 3600;
            this.m = (seconds % 3600) / 60;
            this.s = (seconds % 3600) % 60;
        }

        int toSeconds() {
            return h * 3600 + m * 60 + s;
        }

        List<Double> getDegrees() {
            Double hDegree = (h % 12) * 30d + m * 0.5d + s * (1/120d);
            Double mDegree = m * 6d + s * 0.1d;
            Double sDegree = s * 6d;

            return List.of(hDegree, mDegree, sDegree);
        }

    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        Time t1 = new Time(h1, m1, s1);
        Time t2 = new Time(h2, m2, s2);

        int start = t1.toSeconds();
        int end = t2.toSeconds();

        for (int i = start; i < end; i++) {
            Time s = new Time(i);
            Time e = new Time(i + 1);

            List<Double> d1 = s.getDegrees();
            List<Double> d2 = e.getDegrees();

            if (hourMatch(d1, d2) && minuteMatch(d1, d2)) {
                if (Double.compare(d2.get(0), d2.get(1)) == 0) answer++;
                else answer += 2;
            }
            else if (hourMatch(d1, d2) || minuteMatch(d1, d2)) {
                answer += 1;
            }

        }

        if (start == 0 || start == 43200) {
            answer++;
        }
        return answer;
    }

    public boolean hourMatch(List<Double> s, List<Double> e) {
        if (Double.compare(s.get(0), s.get(2)) > 0 && Double.compare(e.get(0), e.get(2)) <= 0) {
            return true;
        }
        else if (Double.compare(s.get(2), 354d) == 0 && Double.compare(s.get(0), 354d) > 0) {
            return true;
        }
        return false;
    }

    public boolean minuteMatch(List<Double> s, List<Double> e) {
        if (Double.compare(s.get(1), s.get(2)) > 0 && Double.compare(e.get(1), e.get(2)) <= 0) {
            return true;
        }
        else if (Double.compare(s.get(2), 354d) == 0 && Double.compare(s.get(1), 354d) > 0) {
            return true;
        }
        return false;
    }

}