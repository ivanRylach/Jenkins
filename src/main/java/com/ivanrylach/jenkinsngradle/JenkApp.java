package com.ivanrylach.jenkinsngradle;

import com.splunk.logging.SplunkLogEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Ivan Rylach on 8/5/14.
 * ivan@perzo.com
 */
public class JenkApp {

    static final Logger logger = LogManager.getLogger("splunk.logger");

    public static void main(String[] args){

        new Runnable() {
            @Override
            public void run() {
                SplunkLogEvent event1;
                for (int i = 0; i < 100; i++) {
                    event1 = new SplunkLogEvent("Multi thread test", "thread_1");
//                    event1 = new SplunkLogEvent("Multi thread test", "thread_2");
//                    event1 = new SplunkLogEvent("Multi thread test", "thread_3");

                    event1.addPair("userId", "rylaci");
//                    event1.addPair("userId", "stelms");
//                    event1.addPair("userId", "nolanh");


                    event1.addPair("iteration", i + 1);
                    event1.addPair("another iteration", i + 1);
                    logger.info("{}", event1);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.run();

    }


}
