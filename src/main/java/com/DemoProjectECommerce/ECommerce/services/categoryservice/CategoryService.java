package com.DemoProjectECommerce.ECommerce.services.categoryservice;

import com.DemoProjectECommerce.ECommerce.customizehandling.ECommerceApplicationException;
import com.DemoProjectECommerce.ECommerce.entity.categoryentity.Category;
import com.DemoProjectECommerce.ECommerce.entity.categoryentity.CategoryMetadataField;
import com.DemoProjectECommerce.ECommerce.entity.categoryentity.CategoryMetadataFieldValues;
import com.DemoProjectECommerce.ECommerce.model.categorydto.AddingMetadataDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.CategoryAddDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.CategoryDto;
import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.CategoryRepository;
import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.MetaDataFieldRepository;
import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.MetaDataFieldValueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MetaDataFieldRepository      metaDataFieldRepository;
    @Autowired
    MetaDataFieldValueRepository metaDataFieldValueRepository;

    public String addCategory(CategoryAddDto category) {
        Category newCategory = new Category();

        Optional<Category> getName = categoryRepository.findByName(category.getName().toLowerCase());

        if (getName.isPresent()) {
            throw new ECommerceApplicationException("Category name is already present");
        }


        newCategory.setName(category.getName());

        if (category.getParentId() != null) {
            System.out.println("enter");
            Category parent = categoryRepository.findById(category.getParentId())
                                                .orElseThrow(() -> new ECommerceApplicationException("Category not "
                                                                                                     + "found"));
            newCategory.setParentCategoryId(parent);
            Set<Category> child = new HashSet<>();
            child.add(newCategory);
            parent.setChildCategoryId(child);
            System.out.println("out");
        }

        categoryRepository.save(newCategory);

        return "Created Category";
    }

//    Category newCategory = categoryRepository.findById().orElseThrow(() -> new CategoryNotFound("Category not found "
//
//        newCategory.(category.getName());
//
//        categoryRepository.save(newCategory);
//
//        return"Updated Category";


    public List<CategoryDto> viewCategoryList(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);


        List<CategoryDto> categoryDtoList = categoryPage.stream().map(e -> {
            CategoryDto categoryDto = new CategoryDto();
            modelMapper.map(e, categoryDto);
            return categoryDto;
        }).collect(Collectors.toList());
        return categoryDtoList;
    }

    public CategoryDto findByCategoryId(Integer id) {
        Category category = categoryRepository.findById(Long.valueOf(id)).get();

        CategoryDto categoryDto = new CategoryDto();

        modelMapper.map(category, categoryDto);

        return categoryDto;
    }

    public void addMetadataFieldValues(AddingMetadataDto metadataDTO) {
        List<String> myList = new ArrayList<>(Arrays.asList(metadataDTO.getValue().split(",")));

        Set<String> list = new HashSet<>(myList);
        if (list.size() != myList.size()) {
            throw new ECommerceApplicationException("Value should not be duplicate");
        }

        Category category = categoryRepository.findById(metadataDTO.getCategoryId())
                                              .orElseThrow(() -> new ECommerceApplicationException("Category Does not"
                                                                                                   + " exist"));
        if (category.getChildCategoryId().size() != 0) {
            throw new ECommerceApplicationException("Category is not a leaf node category");
        }

        CategoryMetadataField metadataField = metaDataFieldRepository.findById(metadataDTO.getMetadataFeildId())
                                                                     .orElseThrow(() -> new ECommerceApplicationException("MetaDataField Des not exist"));

        CategoryMetadataFieldValues categoryMetadataFieldValues = new CategoryMetadataFieldValues();

        categoryMetadataFieldValues.setCategory(category);
        categoryMetadataFieldValues.setCategoryMetadataField(metadataField);

        categoryMetadataFieldValues.setValue(metadataDTO.getValue());
        metaDataFieldValueRepository.save(categoryMetadataFieldValues);


    }

    public void updateCategory(CategoryDto category) {
    }
}

