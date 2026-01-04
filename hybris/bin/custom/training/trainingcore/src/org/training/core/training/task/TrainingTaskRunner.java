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




//                  EVENTS IN TASK
//        TaskConditionModel cond = modelService.create(TaskConditionModel.class);
//
//                    configure them
//        task.setRunnerBean("MyRunner");
//                    define event name
//        cond.setUniqueID("MyEventArrived");
//                    add to task
//        task.setConditions( Collections.singleton( cond ) );
//
//                    schedule
//        taskService.scheduleTask(task);



//        TaskService taskService = ...

//                    trigger the event
//        taskService.triggerEvent( "MyEventArrived" );




//                  CONDITIONS AND TIMEOUTS IN TASK
//        TaskConditionModel cond1 = modelService.create(TaskConditionModel.class);
//        TaskConditionModel cond2 = modelService.create(TaskConditionModel.class);
//
//                   set single expiration date for the whole task: now + 10min
//        task.setExpirationDate(new Date( System.currentTimeMillis() + (10 * 60 * 1000) ))
//
//                   set expiration date for conditions
//        cond1.setExpirationDate(new Date( System.currentTimeMillis() + (2 * 60 * 1000) ))
//        cond2.setExpirationDate(new Date( System.currentTimeMillis() + (6 * 60 * 1000) ))
    }

    @Override
    public void handleError(TaskService taskService, TaskModel taskModel, Throwable throwable) {

    }
}
