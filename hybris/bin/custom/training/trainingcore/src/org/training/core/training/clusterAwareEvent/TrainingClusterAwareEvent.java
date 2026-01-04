package org.training.core.training.clusterAwareEvent;

import de.hybris.platform.servicelayer.event.ClusterAwareEvent;
import de.hybris.platform.servicelayer.event.PublishEventContext;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public class TrainingClusterAwareEvent extends AbstractEvent implements ClusterAwareEvent {

    private String trainingAttribute;

    @Override
    public boolean canPublish(final PublishEventContext publishEventContext)
    {
        //decide which cluster node should process that event
        //return publishEventContext.getSourceNodeId() != publishEventContext.getTargetNodeId();  //process on a different cluster node only
        //return publishEventContext.getSourceNodeId() < 5 && publishEventContext.getTargetNodeId() >= 5; //process on any event from any cluster node 1-4 to the cluster nodes 5-?
        return true; //allow processing on all cluster nodes
    }

    public void setTrainingAttribute(String trainingAttribute) {
        this.trainingAttribute = trainingAttribute;
    }

    public String getTrainingAttribute() {
        return trainingAttribute;
    }
}


