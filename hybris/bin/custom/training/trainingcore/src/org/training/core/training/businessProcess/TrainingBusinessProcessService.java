package org.training.core.training.businessProcess;

import de.hybris.platform.processengine.BusinessProcessEvent;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Required;
import org.training.core.model.TrainingProcessModel;

public class TrainingBusinessProcessService {

    private BusinessProcessService businessProcessService;
    private ModelService modelService;

    public void createTrainingBusinessProcess() {

        String id = "trainingProcess_" + System.currentTimeMillis();

        System.out.println("TrainingBusinessProcessService.create(): " + id);

        TrainingProcessModel model = businessProcessService.createProcess(id, "TrainingBusinessProcess");
        model.setTrainingAttribute("TEST_EST_TEST");

        modelService.save(model);

        businessProcessService.startProcess(model);
    }

    public void triggerEventWithBusinessProcessCode() {

        String businessProcessId = "trainingProcess_1234";

        System.out.println("TrainingBusinessProcessService.triggerEvent(): " + businessProcessId);

        final BusinessProcessEvent event = BusinessProcessEvent
                .builder(businessProcessId + "_TrainingBusinessProcessEvent")
                .build();

        businessProcessService.triggerEvent(event);

    }

    @Required
    public void setBusinessProcessService(BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    @Required
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
