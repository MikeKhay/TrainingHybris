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
