package org.training.core.training.businessProcess;

import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.task.RetryLaterException;
import org.training.core.model.TrainingProcessModel;

public class Action1 extends AbstractSimpleDecisionAction<TrainingProcessModel> {

    @Override
    public Transition executeAction(TrainingProcessModel model) throws RetryLaterException, Exception {

        System.out.println("Action1");
        double r = Math.random();
        if (r < 0.5) {
            return Transition.OK;
        } else {
            return Transition.NOK;
        }
    }
}
