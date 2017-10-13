package net.mgorski.java8.mod01;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algorithms {

    /**
     * Angle between clock hands
     *
     * @param h hour
     * @param m minute
     * @return angle
     */
    public double angle(int h, int m) {

        double hAngle = 0.5D * (h * 60 + m);
        double mAngle = 6 * m;

        double angle = Math.abs(hAngle - mAngle);

        angle = Math.min(angle, 360 - angle);
        return angle;
    }


    public List<Integer> fibbonacci(int max) {
        return Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(max)
                .map(t -> t[0]).collect(Collectors.toList());


    }

}
