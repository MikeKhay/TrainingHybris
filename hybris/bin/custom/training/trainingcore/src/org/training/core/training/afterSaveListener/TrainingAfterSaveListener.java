package org.training.core.training.afterSaveListener;

import de.hybris.platform.core.PK;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.tx.AfterSaveEvent;
import de.hybris.platform.tx.AfterSaveListener;
import org.springframework.beans.factory.annotation.Required;
import org.training.core.model.TrainingItemModel;

import java.util.Collection;

public class TrainingAfterSaveListener implements AfterSaveListener {

    private ModelService modelService;

    @Override
    public void afterSave(Collection<AfterSaveEvent> events) {

//        System.out.println("TrainingAfterSaveListener");

        for (final AfterSaveEvent event : events)
        {
            final int type = event.getType();
            if (AfterSaveEvent.UPDATE == type) {
                final PK pk = event.getPk();
                if (10102 == pk.getTypeCode())
                {
                    final TrainingItemModel model = modelService.get(pk);
                    System.out.println("AfterSaveEvent.UPDATE");
                }
            }
            if (AfterSaveEvent.CREATE == type) {
                final PK pk = event.getPk();
                if (10102 == pk.getTypeCode())
                {
                    final TrainingItemModel model = modelService.get(pk);
                    System.out.println("AfterSaveEvent.CREATE");
                }
            }
            if (AfterSaveEvent.REMOVE == type) {
                final PK pk = event.getPk();
                if (10102 == pk.getTypeCode())
                {
                    final TrainingItemModel model = modelService.get(pk);
                    System.out.println("AfterSaveEvent.REMOVE");
                }
            }
        }
    }

    @Required
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
