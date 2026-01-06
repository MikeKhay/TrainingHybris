package org.training.core.training.dynamicAttributeHandler;

import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Required;
import org.training.core.model.TrainingItemModel;

public class TrainingDynamicAttributeService {

    private ModelService modelService;

    public void testDynamicAttribute() {

        System.out.println("TrainingDynamicAttributeService.testDynamicAttribute()");

        TrainingItemModel model = modelService.create(TrainingItemModel.class);

        System.out.println(model.getTrainingDynamicAttribute());

        model.setTrainingDynamicAttribute("TEST_TEST_TEST2");

        System.out.println(model.getTrainingDynamicAttribute());

    }

    @Required
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
