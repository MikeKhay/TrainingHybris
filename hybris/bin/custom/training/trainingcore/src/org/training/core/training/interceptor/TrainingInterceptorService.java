package org.training.core.training.interceptor;

import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Required;
import org.training.core.model.TrainingItemModel;

public class TrainingInterceptorService {

    private ModelService modelService;

    public void test() {

        System.out.println("modelService.create()");
        TrainingItemModel model = modelService.create(TrainingItemModel.class);

        System.out.println("modelService.save()");
        modelService.save(model);

        System.out.println("update attribute");
        model.setTrainingAttribute("TEST_TEST");

        System.out.println("modelService.save()");
        modelService.save(model);

//        System.out.println("modelService.get()");
//        TrainingItemModel model2 = modelService.get(model);

//        System.out.println("modelService.remove()");
//        modelService.remove(model);

    }

    @Required
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
