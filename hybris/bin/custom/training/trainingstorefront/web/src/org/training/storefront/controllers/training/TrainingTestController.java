package org.training.storefront.controllers.training;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.core.training.interceptor.TrainingInterceptorService;

import javax.annotation.Resource;

@Controller
public class TrainingTestController extends AbstractPageController {

    @Resource(name = "trainingInterceptorService")
    private TrainingInterceptorService trainingInterceptorService;

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test(
            @RequestParam(value = "id", defaultValue = "0", required = false) final int id
    ) throws CMSItemNotFoundException {
        System.out.println("TEST TEST TEST");
        System.out.println(id);


        if (id == 1) {
            trainingInterceptorService.test();
        }

        return REDIRECT_PREFIX + ROOT;
    }

}
