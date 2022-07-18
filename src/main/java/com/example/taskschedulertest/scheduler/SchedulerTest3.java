package com.example.taskschedulertest.scheduler;

import com.example.taskschedulertest.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SchedulerTest3 extends SchedulerRunner {

    private final TaskScheduler thirdTaskScheduler;

    public SchedulerTest3(TaskScheduler thirdTaskScheduler) {
        this.thirdTaskScheduler = thirdTaskScheduler;
    }
    public void scheduled5() {
        thirdTaskScheduler.schedule(() -> {
            log.info(new Date() + " " + Thread.currentThread().getName() + ": scheduled5");
            Utils.sleep();
        }, new CronTrigger("* * * * * *"));
    }

    @Override
    public void run() {
        scheduled5();
    }
}
