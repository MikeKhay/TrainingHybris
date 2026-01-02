package org.training.core.training.jobPerformable;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

public class TrainingJobPerformable extends AbstractJobPerformable<CronJobModel> {

    @Override
    public PerformResult perform(CronJobModel cronJob) {
        for (int i = 0; i <= 1000; i++) {
            try {
                System.out.println("Greeting from MyJobPerformable for " + i + " times.");
                Thread.sleep(5000);

                if (clearAbortRequestedIfNeeded(cronJob)) {
                    System.out.println("The job is aborted.");
                    return new PerformResult(CronJobResult.ERROR, CronJobStatus.ABORTED);
                }
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //the following will be executed when the loop is finished
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    @Override
    public boolean isAbortable()
    {
        return true;
    }
}
