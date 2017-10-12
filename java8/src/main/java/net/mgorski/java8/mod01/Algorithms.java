package net.mgorski.java8.mod01;

public class Algorithms {

    /**
     * Angle between clock hands
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

}
