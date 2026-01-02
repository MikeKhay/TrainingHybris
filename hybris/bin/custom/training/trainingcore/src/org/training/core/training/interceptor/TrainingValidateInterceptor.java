package org.training.core.training.interceptor;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import org.training.core.model.TrainingItemModel;

public class TrainingValidateInterceptor implements ValidateInterceptor<TrainingItemModel> {
    @Override
    public void onValidate(TrainingItemModel trainingItemModel, InterceptorContext interceptorContext) throws InterceptorException {
        System.out.println("TrainingValidateInterceptor");

    }
}
