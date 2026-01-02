package org.training.core.training.interceptor;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;
import org.training.core.model.TrainingItemModel;

public class TrainingRemoveInterceptor implements RemoveInterceptor<TrainingItemModel> {
    @Override
    public void onRemove(TrainingItemModel trainingItemModel, InterceptorContext interceptorContext) throws InterceptorException {
        System.out.println("TrainingRemoveInterceptor");

    }
}
