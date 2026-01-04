package org.training.core.training.clusterAwareEvent;

import de.hybris.platform.servicelayer.event.EventService;
import org.springframework.beans.factory.annotation.Required;

public class TrainingClusterAwareService {

    private EventService eventService;

    public void publishEvent() {

        System.out.println("TrainingClusterAwareService.publishEvent()");

        TrainingClusterAwareEvent event = new TrainingClusterAwareEvent();
        event.setTrainingAttribute("TEST_TEST_TEST");

        eventService.publishEvent(event);
    }

    @Required
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
