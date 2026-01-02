package org.training.core.training.interceptor;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import org.training.core.model.TrainingItemModel;

public class TrainingPrepareInterceptor implements PrepareInterceptor<TrainingItemModel> {
    @Override
    public void onPrepare(TrainingItemModel trainingItemModel, InterceptorContext interceptorContext) throws InterceptorException {
        System.out.println("TrainingPrepareInterceptor");

    }
}
