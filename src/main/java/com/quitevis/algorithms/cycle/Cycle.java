package com.quitevis.algorithms.cycle;

import org.slf4j.Logger;

/**
 * Created by lordbritishix on 18/06/15.
 */
public class Cycle {
    //Find the length of the loop
    public int findLoopLength(int[] linkedListArray) {
        Logger log = org.slf4j.LoggerFactory.getLogger(Cycle.class);

        if (linkedListArray.length <= 1) {
            return 0;
        }

        int hare = 0;
        int rabbit = 0;

        //Break when loop is detected - this will stop the moment rabbit catches up with hare,
        //which will be somewhere inside the loop. Hare will be equal to rabbit when this happens
        while (true) {
            //Hare
            hare = linkedListArray[hare];

            //Rabbit
            rabbit = linkedListArray[rabbit];

            rabbit = linkedListArray[rabbit];
            log.trace("*" + hare);
            log.trace("@" + rabbit);

            //If equal, rabbit has passed hare because hare is faster.
            //Also, we are inside the loop here now
            if (hare == rabbit) {
                log.trace("found loop! location: {}", rabbit);
                break;
            }
        }

        //Find how long the cycle is by moving hare 1 step every loop.
        //Eventually, hare will be equal to rabbit again because we are
        //already in a loop
        int cycleLength = 0;
        while (true) {
            hare = linkedListArray[hare];
            cycleLength++;
            if (hare == rabbit) {
                break;
            }
        }

        return cycleLength;
    }
}
