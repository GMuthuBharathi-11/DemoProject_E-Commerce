//package com.DemoProjectECommerce.ECommerce.controllers.productcontroller;
//
//import com.DemoProjectECommerce.ECommerce.controllers.CategoryController.CategoryController;
//import com.DemoProjectECommerce.ECommerce.entity.CategoryMetadataFeild;
//import com.DemoProjectECommerce.ECommerce.model.*;
//import com.DemoProjectECommerce.ECommerce.repositories.CategoryRepository.CategoryRepository;
//import com.DemoProjectECommerce.ECommerce.services.CategoryService.CategoryService;
//import com.DemoProjectECommerce.ECommerce.services.CategoryService.MetaDataService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//public class productcontroller
//{
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    ProductService productService;
//    @Autowired
//    ProductVariation productVariation;
//    Logger logger = LoggerFactory.getLogger(ProductController.class);
//
//    @PostMapping("/add-productData")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<String> add(@RequestBody productDto productdto) {
//        logger.info("SellerController :: Adding a product feild");
//        String responseMessage = productService.add(procductFieldDto);
//        return new ResponseEntity<String>(responseMessage, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/list-productData")
//    @PreAuthorize("hasRole('ROLE_SELLER)")
//    public ResponseEntity<List<Page<productDto>>> getAllproducts(
//
//                                                                                 ) {
//
//        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//        return ResponseEntity.ok(productservice.getAllproductfeild(pageRequest));
//    }
//
//    @PostMapping("/add")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<String> addProduct(@RequestBody productdto product) {
//        productService.addProduct(category);
//        return new ResponseEntity<>("Product Added", HttpStatus.ACCEPTED);
//    }
//
//    @PutMapping("/update")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<String> updateCategory(@RequestBody ProductDto product) {
//        productService.updateproduct(category);
//        return new ResponseEntity<>("Product Updated", HttpStatus.ACCEPTED);
//    }
//
//    @GetMapping("/view/{id}")
//    public ResponseEntity<Productdto> findAllCategory(@PathVariable("id") Integer id) {
//        ProductDto productdto = productService.findByProductId(id);
//        return new ResponseEntity<>(productDto, HttpStatus.OK);
//    }
//
//    @GetMapping("/viewAll")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<List<ProductDto>> viewAllCategory( {
//        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//        List<CategoryDto> fieldList = productService.viewCategoryList(pageRequest);
//        return new ResponseEntity<>(fieldList, HttpStatus.OK);
//    }
//
//
//}
