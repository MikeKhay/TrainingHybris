package org.training.core.training.interceptor;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.LoadInterceptor;
import org.training.core.model.TrainingItemModel;

public class TrainingLoadInterceptor implements LoadInterceptor<TrainingItemModel> {
    @Override
    public void onLoad(TrainingItemModel trainingItemModel, InterceptorContext interceptorContext) throws InterceptorException {
        System.out.println("TrainingLoadInterceptor");

    }
}
