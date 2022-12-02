package com.DemoProjectECommerce.ECommerce.controllers.categorycontroller;
import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.CategoryRepository;
import com.DemoProjectECommerce.ECommerce.entity.categoryentity.CategoryMetadataField;
import com.DemoProjectECommerce.ECommerce.services.categoryservice.CategoryService;
import com.DemoProjectECommerce.ECommerce.services.categoryservice.MetaDataService;
import com.DemoProjectECommerce.ECommerce.model.categorydto.AddingMetadataDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.MetaDataFieldDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.CategoryAddDto;
import com.DemoProjectECommerce.ECommerce.model.categorydto.CategoryDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;
    @Autowired
    MetaDataService metaDataService;
    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @PostMapping("/add-metaData")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> add(@RequestBody MetaDataFieldDto metaDataFieldDto) {
        logger.info("AdminController :: Adding a meta data field");
        String responseMessage = metaDataService.add(metaDataFieldDto);
        return new ResponseEntity<String>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/list-metaData")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Page<CategoryMetadataField>>> getAllMetaDataFields(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
                                                                                 ) {

        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return ResponseEntity.ok(metaDataService.getAllMetaDataFields(pageRequest));
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> addCategory(@RequestBody CategoryAddDto category) {
        categoryService.addCategory(category);
        return new ResponseEntity<>("Category Added", HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryDto category) {
        categoryService.updateCategory(category);
        return new ResponseEntity<>("Category Updated", HttpStatus.ACCEPTED);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<CategoryDto> findAllCategory(@PathVariable("id") Integer id) {
        CategoryDto categoryDto = categoryService.findByCategoryId(id);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @GetMapping("/viewAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<CategoryDto>> viewAllCategory(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy

                                                            ) {
        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        List<CategoryDto> fieldList = categoryService.viewCategoryList(pageRequest);
        return new ResponseEntity<>(fieldList, HttpStatus.OK);
    }

    @PostMapping("/add-metadataValue")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> addFieldValue(@RequestBody AddingMetadataDto metadataDTO) {
        categoryService.addMetadataFieldValues(metadataDTO);
        return new ResponseEntity<>("Metadata Field Value Added", HttpStatus.ACCEPTED);
    }
}
//    @PutMapping("/update-metadatavalues")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<String> updatemetadatafield(@RequestParam MetaDataFieldDto metaDataFieldDto){
//        categoryService.updateCategory(metaDataFieldDto);
//        return new ResponseEntity<>("Metadata Field Value Updated",HttpStatus.OK);
//    }
//
//        @GetMapping("/viewAllCat")
//        @PreAuthorize("hasRole('ROLE_SELLER')")
//        public RequestEntity<String> viewAllCategories(@RequestParam CategoryDto categoryDto)
////
////    @RequestParam(defaultValue = "0")
////    Integer pageNo,
////    @RequestParam(defaultValue = "10")
////    Integer pageSize,
////    @RequestParam(defaultValue = "id")
////    String sortBy
////    {
////
////        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//    @GetMapping("/viewALLCat")
//    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
//    public RequestEntity<String> viewAllCategories(@RequestParam CategoryDto categoryDto)
////
////      categoryService.addMetadataFieldValues(metadataDTO);
////        return new ResponseEntity<>("Metadata Field Value Added", );
//}
