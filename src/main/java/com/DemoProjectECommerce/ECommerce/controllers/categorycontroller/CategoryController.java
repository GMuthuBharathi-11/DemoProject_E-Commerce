package com.DemoProjectECommerce.ECommerce.controllers.categorycontroller;

import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.CategoryRepository;
import com.DemoProjectECommerce.ECommerce.services.categoryservice.CategoryService;
import com.DemoProjectECommerce.ECommerce.services.categoryservice.MetaDataService;
import com.DemoProjectECommerce.ECommerce.model.categorydto.MetaDataFieldDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.AddingMetadataDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.CategoryAddDto;
import com.DemoProjectECommerce.ECommerce.entity.CategoryMetadataField;
import com.DemoProjectECommerce.ECommerce.model.categorydto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;
    @Autowired
    MetaDataService metaDataService;

    @PostMapping("/add-metaData")
    public ResponseEntity<String> add(@RequestBody MetaDataFieldDto metaDataFieldDto) {
        System.out.println("AdminController :: Adding a meta data field");
        String responseMessage = metaDataService.add(metaDataFieldDto);
        return new ResponseEntity<String>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/list-metaData")
    public ResponseEntity<List<Page<CategoryMetadataField>>> getAllMetaDataFields(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return ResponseEntity.ok(metaDataService.getAllMetaDataFields(pageRequest));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryAddDto category) {
        categoryService.addCategory(category);
        return new ResponseEntity<>("Category Added", HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryDto category) {
        categoryService.updateCategory(category);
        return new ResponseEntity<>("Category Updated", HttpStatus.ACCEPTED);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<CategoryDto> findAllCategory(@PathVariable("id") Long id) {
        CategoryDto categoryDto = categoryService.findByCategoryId(id);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<Page<CategoryDto>> viewAllCategory(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
                                                            )
    {
        Pageable pageRequest = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
        Page<CategoryDto> fieldList =  categoryService.viewCategoryList(pageRequest);
        return  new ResponseEntity<>(fieldList,HttpStatus.OK);
    }

    @PostMapping("/add-metadataValue")
    public ResponseEntity<String> addFieldValue(@RequestBody AddingMetadataDto metadataDTO) {
        categoryService.addMetadataFieldValues(metadataDTO);
        return new ResponseEntity<>("Metadata Field Value Added", HttpStatus.ACCEPTED);
    }
}
