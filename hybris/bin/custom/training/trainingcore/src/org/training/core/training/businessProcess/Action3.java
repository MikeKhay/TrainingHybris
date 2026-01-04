package org.training.core.training.businessProcess;

import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction;
import de.hybris.platform.task.RetryLaterException;
import org.training.core.model.TrainingProcessModel;

public class Action3 extends AbstractSimpleDecisionAction<TrainingProcessModel> {

    @Override
    public Transition executeAction(TrainingProcessModel model) throws RetryLaterException, Exception {
        System.out.println("Action3");
        return Transition.OK;
    }
}
