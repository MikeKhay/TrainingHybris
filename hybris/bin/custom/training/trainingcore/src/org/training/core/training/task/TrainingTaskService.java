package org.training.core.training.task;

import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.task.TaskModel;
import de.hybris.platform.task.TaskService;
import org.springframework.beans.factory.annotation.Required;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TrainingTaskService {

    private ModelService modelService;
    private TaskService taskService;

    public void createTask() {

        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("TrainingTaskService.createTask() [ " + time + " ]");

        // create model
        TaskModel task = modelService.create(TaskModel.class);

        // configure it
        task.setRunnerBean("trainingTaskRunner"); // the action bean name
        task.setExecutionDate(new Date(System.currentTimeMillis() + 1 * 60 * 1000));  // the execution time - 1min after creating

        // schedule
        taskService.scheduleTask(task);





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

    @Required
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Required
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
