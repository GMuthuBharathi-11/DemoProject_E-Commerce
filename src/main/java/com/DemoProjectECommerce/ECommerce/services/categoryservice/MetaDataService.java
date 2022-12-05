package com.DemoProjectECommerce.ECommerce.services.categoryservice;


import com.DemoProjectECommerce.ECommerce.entity.CategoryMetadataField;
import com.DemoProjectECommerce.ECommerce.model.categorydto.MetaDataFieldDto;
import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.MetaDataFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaDataService
{
    @Autowired
    MetaDataFieldRepository metaDataFieldRepository;

    public String add(MetaDataFieldDto metaDataFieldDto) {
        CategoryMetadataField metaDataField =new CategoryMetadataField();

        if(metaDataFieldRepository.findByMetaDataFieldNameLike(metaDataFieldDto.getMetaDataFieldName()).isPresent())
        {
            return "Meta Data Field Already Exists!";
        }
        metaDataField.setMetaDataFieldName(metaDataFieldDto.getMetaDataFieldName());

        metaDataFieldRepository.save(metaDataField);
        return "Added Successfully";
    }
    public List<Page<CategoryMetadataField>> getAllMetaDataFields(Pageable pageable) {
        Page<CategoryMetadataField> metaDataFieldDto = metaDataFieldRepository.findAll(pageable);
        return metaDataFieldDto.stream().map(e ->
                                             {
                                                 MetaDataFieldDto metaDataFieldDto1 = new  MetaDataFieldDto();
                                                 metaDataFieldDto1.setId(e.getId());
                                                 metaDataFieldDto1.setMetaDataFieldName(e.getMetaDataFieldName());
                                                 return metaDataFieldDto;
                                             }).collect(Collectors.toList());
    }

}
