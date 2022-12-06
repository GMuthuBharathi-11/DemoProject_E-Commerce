//package com.DemoProjectECommerce.ECommerce.controllers.productcontroller;
//
//import com.DemoProjectECommerce.ECommerce.model.productdto.ProductDto;
//import com.DemoProjectECommerce.ECommerce.model.productdto.ProductViewCustomerDto;
//import com.DemoProjectECommerce.ECommerce.model.productdto.ProductViewDto;
//import com.DemoProjectECommerce.ECommerce.services.productservice.ProductService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/product")
//public class ProductController
//{
//    @Autowired
//    ProductService productService;
//    Logger logger = LoggerFactory.getLogger(ProductController.class);
//    @PostMapping("/add")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<String> addProduct(Authentication authentication, @RequestBody ProductDto productDto) throws InterruptedException {
//        logger.info("ProductController :: Adding product");
//        String username = authentication.getName();
//        productService.addProduct(username,productDto);
//        return new ResponseEntity<>("Product is added successfully", HttpStatus.ACCEPTED);
//    }
//    @GetMapping("/view/{id}")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<ProductViewDto> viewProduct(Authentication authentication, @PathVariable("id") Integer id){
//        String username = authentication.getName();
//        ProductViewDto productViewDto = productService.viewProduct(username,id);
//        return new ResponseEntity<>(productViewDto, HttpStatus.OK);
//    }
//    @GetMapping("/viewCustomer/{id}")
//    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
//    public ResponseEntity<ProductViewCustomerDto> viewProductCustomer(@PathVariable("id") Integer id){
//
//        ProductViewCustomerDto productDTO=productService.viewProductForCustomer(id);
//        return new ResponseEntity<>(productDTO, HttpStatus.OK);
//    }
//    @GetMapping("/viewAdmin/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<ProductViewCustomerDto> viewProductAdmin(@PathVariable("id") Integer id){
//
//        ProductViewCustomerDto productViewCustomerDto=productService.viewProductForAdmin(id);
//        return new ResponseEntity<>(productViewCustomerDto, HttpStatus.OK);
//    }
//    @GetMapping("/viewAll")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<List<ProductViewDto>> viewAllProducts(Authentication authentication,
//                                                                @RequestParam(defaultValue = "0") Integer pageNo,
//                                                                @RequestParam(defaultValue = "10") Integer pageSize,
//                                                                @RequestParam(defaultValue = "id") String sortBy
//
//                                                               ){
//        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//        String               username  = authentication.getName();
//        List<ProductDto>fieldList = productService.viewProductList(username, pageRequest);
//        return new ResponseEntity<>(fieldList,HttpStatus.OK);
//    }
//
//    @GetMapping("/customer-viewAll/{id}")
//    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
//    public ResponseEntity<List<ProductViewCustomerDto>> viewAllProductsForCustomer(@PathVariable Integer id,
//                                                                                   @RequestParam(defaultValue = "0") Integer pageNo,
//                                                                                   @RequestParam(defaultValue = "10") Integer pageSize,
//                                                                                   @RequestParam(defaultValue = "id") String sortBy
//
//                                                                                  ){
//        Pageable pageRequest= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
//
//        List<ProductViewCustomerDto> fieldList = productService.viewProductListForCustomer(id,pageRequest);
//        return new ResponseEntity<>(fieldList,HttpStatus.OK);
//    }
//    @GetMapping("/customer-viewSimilar/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<List<ProductViewCustomerDto>> viewSimilarProductsForCustomer(@PathVariable Integer id,
//                                                                                       @RequestParam(defaultValue = "0") Integer pageNo,
//                                                                                       @RequestParam(defaultValue = "10") Integer pageSize,
//                                                                                       @RequestParam(defaultValue = "id") String sortBy
//
//                                                                                      ){
//        Pageable pageRequest= PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//        List<ProductViewCustomerDto> fieldList = productService.viewSimilarProductListForCustomer(id,pageRequest);
//        return new ResponseEntity<>(fieldList,HttpStatus.OK);
//    }
//    @GetMapping("/admin-viewAll")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<List<ProductViewCustomerDto>> viewAllProductsForAdmin(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy
//
//                                                                               ){
//        Pageable pageRequest= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
//
//        List<ProductViewCustomerDto> fieldList = productService.viewProductListForAdmin(pageRequest);
//        return new ResponseEntity<>(fieldList,HttpStatus.OK);
//    }
//    @PatchMapping("/activate/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<String> activateProduct(@PathVariable Integer id) throws InterruptedException {
//        logger.info("AdminController :: Activate product");
//        String responseMessage= productService.activateProduct(Long.valueOf(id));
//        return new ResponseEntity<>(responseMessage, HttpStatus.ACCEPTED);
//    }
//
//    @PatchMapping("/deactivate/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<String> deactivateProduct(@PathVariable Integer id) throws InterruptedException {
//        logger.info("AdminController :: Activate product");
//        String responseMessage= productService.deactivateProduct(Long.valueOf(id));
//        return new ResponseEntity<>(responseMessage, HttpStatus.ACCEPTED);
//    }
//    @PutMapping("/update/{id}")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<String> updateProduct(Authentication authentication,@RequestBody ProductDto productDto,@PathVariable("id") Integer id){
//        String username = authentication.getName();
//        productService.updateProduct(username,ProductDto(),id);
//        return new ResponseEntity<>("Product Updated", HttpStatus.ACCEPTED);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('ROLE_SELLER')")
//    public ResponseEntity<String> deletingProduct(@PathVariable("id") Long id) throws InterruptedException {
//        logger.info("ProductController :: Delete Product execution");
//        //String username = authentication.getName();
//        productService.deleteById(id);
//        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.ACCEPTED);
//    }
//}
//
//
