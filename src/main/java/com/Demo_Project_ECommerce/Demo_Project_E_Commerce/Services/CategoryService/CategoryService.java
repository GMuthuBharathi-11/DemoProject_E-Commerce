//package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CategoryService;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.CustomizeErrorHandling.ECommerceApplicationException;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Category;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CategoryRepository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import javax.validation.Valid;
//import java.util.Objects;
//
//@Service
//public class CategoryService
//{
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @PostMapping("/create")
//    public static ResponseEntity<ECommerceApplicationException> createCategory(@Valid @RequestBody Category category) {
//        if (Objects.nonNull(CategoryService.readCategory(category.getCategoryName()))) {
//            return new ResponseEntity<ECommerceApplicationException>(new ECommerceApplicationException("category already exists"), HttpStatus.CONFLICT);
//        }
//       CategoryService .createCategory(category);
//        return new ResponseEntity<>(new ECommerceApplicationException( "created the category"), HttpStatus.CREATED);
//    }
//    public static Category readCategory(String categoryName) {
//        return CategoryRepository.findByCategoryName(categoryName);
//    }
////    public void createCategory(Category category) {
////        categoryRepository.save(category);
////    }
//}
