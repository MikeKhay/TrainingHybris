package org.training.core.training.interceptor;

import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import org.training.core.model.TrainingItemModel;

public class TrainingInitDefaultsInterceptor implements InitDefaultsInterceptor<TrainingItemModel> {
    @Override
    public void onInitDefaults(TrainingItemModel trainingItemModel, InterceptorContext interceptorContext) throws InterceptorException {
        System.out.println("TrainingInitDefaultsInterceptor");

    }
}
