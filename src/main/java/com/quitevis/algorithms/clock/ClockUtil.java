package com.quitevis.algorithms.clock;

/**
 * Created by lordbritishix on 02/06/15.
 */
public class ClockUtil {
    /**
     * abs(Degree from 12 o'clock to hour hand - Degree from 12 o'clock to minute hand) =
     * degree between hour and minute hand, on a minute granularity
     */
    public int getAngle(int hour, int min) {
        //Hour hand turns 360 in 720 minutes or 1/2 degree per minute / 30 degrees per hour
        //number of 30 degree angle + the remaining angle formed by the hour hand past the hour
        //which depends on where the minute hand is at the moment
        //
        //degree of hour hand = 30h * 0.5m ---> 0.5(60h + m)
        int degreeOfHourHand = (int) (0.5 * (60 * hour + min));

        //Minute hand turns 360 in 60 minutes or 6 degrees per minute
        //degree of minute hand = 6 * min
        int degreeOfMinuteHand = 6 * min;

        return Math.abs(degreeOfHourHand - degreeOfMinuteHand);
    }
}
