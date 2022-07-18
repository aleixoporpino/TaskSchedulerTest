package com.example.taskschedulertest.scheduler;

import com.example.taskschedulertest.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SchedulerTest2 extends SchedulerRunner {

    private final TaskScheduler secondTaskScheduler;

    public SchedulerTest2(TaskScheduler secondTaskScheduler) {
        this.secondTaskScheduler = secondTaskScheduler;
    }

    public void scheduled3() {
        secondTaskScheduler.schedule(() -> {
            log.info(new Date() + " " + Thread.currentThread().getName() + ": scheduled3");
            Utils.sleep();
        }, new CronTrigger("* * * * * *"));
    }

    public void scheduled4() {
        secondTaskScheduler.schedule(() -> {
            log.info(new Date() + " " + Thread.currentThread().getName() + ": scheduled4");
            Utils.sleep();
        }, new CronTrigger("* * * * * *"));
    }

    @Override
    public void run() {
        scheduled3();
        scheduled4();
    }
}
