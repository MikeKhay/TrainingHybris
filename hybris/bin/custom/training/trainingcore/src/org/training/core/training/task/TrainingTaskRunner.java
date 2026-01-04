package org.training.core.training.task;

import de.hybris.platform.task.RetryLaterException;
import de.hybris.platform.task.TaskModel;
import de.hybris.platform.task.TaskRunner;
import de.hybris.platform.task.TaskService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TrainingTaskRunner implements TaskRunner<TaskModel> {

    @Override
    public void run(TaskService taskService, TaskModel task) throws RetryLaterException {

        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("TrainingTaskRunner.run() [ " + time + " ]");

        if (Math.random() < 0.8) {
            if( task.getRetry().intValue() <= 10 ) {
                System.out.println("TrainingTaskRunner status: Can not perform " + task.getRetry().intValue() + " times. [ " + time + " ]");

                RetryLaterException ex = new RetryLaterException("cannot perform");
                ex.setDelay(10 * 1000 ); // delay for 10 sec
                throw ex;
            } else {
                throw new IllegalStateException("finally cannot perform after " + task.getRetry() + " retries");
            }
        } else {
            System.out.println("TrainingTaskRunner status: Performed [ " + time + " ]");
        }
    }

    @Override
    public void handleError(TaskService taskService, TaskModel taskModel, Throwable throwable) {

    }
}
