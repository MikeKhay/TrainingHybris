package org.training.core.training.clusterAwareEvent;

import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;

public class TrainingClusterAwareListener extends AbstractEventListener<TrainingClusterAwareEvent> {

    @Override
    protected void onEvent(TrainingClusterAwareEvent trainingClusterAwareEvent) {

        System.out.println("TrainingClusterAwareListener.onEvent(): " + trainingClusterAwareEvent.getTrainingAttribute());
    }
}
