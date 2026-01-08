package org.training.core.training.solr;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;
import org.training.core.model.ManufactureZoneModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrainingManufactureZoneValueProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider {

    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(IndexConfig indexConfig, IndexedProperty indexedProperty, Object model) throws FieldValueProviderException {
        if (model instanceof ProductModel productModel) {
            return createFieldValue(productModel, indexedProperty);
        }
        else {
            throw new FieldValueProviderException("Error occurred in TrainingManufactureZoneValueProvider!!");
        }
    }

    protected List<FieldValue> createFieldValue(final ProductModel productModel, final IndexedProperty indexedProperty) {
        final List<FieldValue> fieldValues = new ArrayList<>();
        final List<ManufactureZoneModel> zoneModelList = productModel.getManufactureZones();

        if (CollectionUtils.isNotEmpty(zoneModelList)) {
            for (final ManufactureZoneModel zoneModel : zoneModelList) {
                if (StringUtils.isNotBlank(zoneModel.getZoneName())) {

                    final Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, null);
                    for (final String fieldName : fieldNames) {
                        fieldValues.add(new FieldValue(fieldName, zoneModel.getZoneName()));
                    }

                }
            }

        } else {
            System.out.println("ManufactureZones is Empty for Product :: " + productModel.getCode());
        }
        return fieldValues;
    }

    @Required
    public void setFieldNameProvider(FieldNameProvider fieldNameProvider) {
        this.fieldNameProvider = fieldNameProvider;
    }

}
