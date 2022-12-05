package com.DemoProjectECommerce.ECommerce.services.categoryservice;

import com.DemoProjectECommerce.ECommerce.customizehandling.ECommerceApplicationException;
import com.DemoProjectECommerce.ECommerce.entity.Category;
import com.DemoProjectECommerce.ECommerce.entity.CategoryMetadataField;
import com.DemoProjectECommerce.ECommerce.entity.CategoryMetadataFieldValues;
import com.DemoProjectECommerce.ECommerce.model.categorydto.AddingMetadataDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.CategoryAddDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.CategoryDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.ChildCategoryDto;
import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.CategoryRepository;
import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.MetaDataFieldRepository;
import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.MetaDataFieldValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository           categoryRepository;
    @Autowired
    MetaDataFieldRepository      metaDataFieldRepository;
    @Autowired
    MetaDataFieldValueRepository metaDataFieldValueRepository;

    public String addCategory(CategoryAddDto categoryDto) {

//        Category newCategory = new Category();

        Optional<Category> getName = categoryRepository.findByName(categoryDto.getName().toLowerCase());

        if (getName.isPresent()) {
            throw new ECommerceApplicationException("Category Name is Already Present");
        }

        if (Optional.ofNullable(categoryDto.getParentId()).isPresent()) {
            System.out.println("enter");
            Category newCategory = new Category();
            newCategory.setName(categoryDto.getName());
            Category parent = categoryRepository.findById(categoryDto.getParentId())
                                                .orElseThrow(() -> new ECommerceApplicationException("Category Not "
                                                                                                     + "Found"));
            newCategory.setParentCategory(parent);
            categoryRepository.save(newCategory);
            System.out.println("out");
        }
        else {
            Category newCategory = new Category();
            newCategory.setName(categoryDto.getName());
            categoryRepository.save(newCategory);
        }

        return "Created Category";
    }
    public String updateCategory(CategoryDto category) {
        Category newCategory = categoryRepository.findById(category.getId())
                                                 .orElseThrow(() -> new ECommerceApplicationException("Category not found for corresponding Id"));
        newCategory.setName(category.getName());

        categoryRepository.save(newCategory);

        return "Updated Category";
    }

    public Page<CategoryDto> viewCategoryList(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);

        return categoryPage.map(category -> CategoryDto.builder()
                                                       .id(category.getId())
                                                       .name(category.getName())
                                                       .childCategoryId(category.getChildCategoryId().stream()
                                                       .map(child -> ChildCategoryDto.builder()
                                                       .id(child.getId()).name(child.getName())
                                                       .build())
                                                       .collect(Collectors.toSet()))
                                                       .parentCategory(category.getParentCategory())
                                                       .build());
    }

    public CategoryDto findByCategoryId(Long Id) {
        Category category = categoryRepository.findById(Id)
                                              .orElseThrow(() -> new ECommerceApplicationException(" No category "
                                                                                                   + "Found with this"
                                                                                                   + " " + Id));
        return CategoryDto.builder()
                          .id(category.getId())
                          .name(category.getName())
                          .childCategoryId(category.getChildCategoryId().stream()
                          .map(child -> ChildCategoryDto.builder()
                          .id(child.getId()).name(child.getName())
                          .build())
                          .collect(Collectors.toSet()))
                          .parentCategory(category.getParentCategory())
                          .build();

    }

    public void addMetadataFieldValues(AddingMetadataDto metadataDTO) {
        List<String> myList = new ArrayList<>(Arrays.asList(metadataDTO.getValue().split(",")));

        Set<String> list = new HashSet<>(myList);
        if (list.size() != myList.size()) {
            throw new ECommerceApplicationException("Value Should Not Be Duplicate");
        }

        Category category = categoryRepository.findById(metadataDTO.getCategoryId())
                                              .orElseThrow(() -> new ECommerceApplicationException("Category Does not"
                                                                                                   + " exist"));
        if (category.getChildCategoryId().size() != 0) {
            throw new ECommerceApplicationException("Category is not a leaf node category");
        }

        CategoryMetadataField metadataField = metaDataFieldRepository.findById(metadataDTO.getMetadataFieldId())
                                                                     .orElseThrow(() -> new ECommerceApplicationException("MetaDataField Des not exist"));

        CategoryMetadataFieldValues categoryMetadataFieldValues = new CategoryMetadataFieldValues();

        categoryMetadataFieldValues.setCategory(category);
        categoryMetadataFieldValues.setCategoryMetadataField(metadataField);

        categoryMetadataFieldValues.setValue(metadataDTO.getValue());
        metaDataFieldValueRepository.save(categoryMetadataFieldValues);


    }
}

