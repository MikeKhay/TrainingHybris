package org.training.core.training.dynamicAttributeHandler;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import org.training.core.model.TrainingItemModel;

public class TrainingDynamicAttributeHandler implements DynamicAttributeHandler<String, TrainingItemModel> {
    @Override
    public String get(TrainingItemModel model) {
        System.out.println("TrainingDynamicAttributeHandler.get()");

        return "TEST_TEST_TEST";
    }

    @Override
    public void set(TrainingItemModel model, String s) {
        System.out.println("TrainingDynamicAttributeHandler.set()");
    }
}
