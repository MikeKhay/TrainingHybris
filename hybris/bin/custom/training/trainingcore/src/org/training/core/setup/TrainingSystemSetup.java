package org.training.core.setup;

import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;
import org.training.core.constants.TrainingCoreConstants;

import java.util.ArrayList;
import java.util.List;

@SystemSetup(extension = TrainingCoreConstants.EXTENSIONNAME)
public class TrainingSystemSetup extends AbstractSystemSetup {

    public static final String IMPORT_ACCESS_RIGHTS = "accessRights";

    @SystemSetup(type = SystemSetup.Type.ESSENTIAL, process = SystemSetup.Process.ALL)
    public void createEssentialData(final SystemSetupContext context)
    {
        importImpexFile(context, "/trainingcore/training/job-perfomable.impex");
    }

    @Override
    @SystemSetupParameterMethod
    public List<SystemSetupParameter> getInitializationOptions()
    {
        final List<SystemSetupParameter> params = new ArrayList<>();

        params.add(createBooleanSystemSetupParameter(IMPORT_ACCESS_RIGHTS, "Import Users & Groups", true));

        return params;
    }
}
