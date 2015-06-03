package com.quitevis.algorithms.clock;

/**
 * Created by lordbritishix on 02/06/15.
 */
public class ClockUtil {
    /**
     * abs(Degree from reference point to hour hand - Degree from reference point to minute hand) =
     * degree between hour and minute hand
     */
    public int getAngle(int hour, int min) {
        //Hour hand turns 360 in 720 minutes or 1/2 degree per minute
        //degree of hour hand = 1/2 * (hour, converted in minute + minute)
        int degreeOfHourHand = (int) (0.5 * (60 * hour + min));

        //Minute hand turns 360 in 60 minutes or 6 degree per minute
        //degree of minute hand = 6 * min
        int degreeOfMinuteHand = 6 * min;

        return Math.abs(degreeOfHourHand - degreeOfMinuteHand);
    }
}
