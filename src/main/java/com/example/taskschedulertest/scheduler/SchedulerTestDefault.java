package com.example.taskschedulertest.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Show how default schedulers work when using annotation
 * One will only execute when the other finishes and vice versa.
 * That's because annotation based schedulers use a default TaskScheduler defined by spring
 */
@Service
@Slf4j
public class SchedulerTestDefault {

    @Scheduled(fixedDelay = 1000)
    public void defaultSchedulerTask() throws InterruptedException {
        log.info("Calling defaultSchedulerTask");
        Thread.sleep(1000);
    }

    @Scheduled(fixedDelay = 1000)
    public void defaultSchedulerTask2() throws InterruptedException {
        log.info("Calling defaultSchedulerTask 2");
        Thread.sleep(1000);
    }
}
