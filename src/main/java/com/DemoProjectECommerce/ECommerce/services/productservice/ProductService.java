//package com.DemoProjectECommerce.ECommerce.services.productservice;
//
//import com.DemoProjectECommerce.ECommerce.customizehandling.ECommerceApplicationException;
//import com.DemoProjectECommerce.ECommerce.email.emailsenderservice.EmailSenderService;
//import com.DemoProjectECommerce.ECommerce.entity.*;
//import com.DemoProjectECommerce.ECommerce.model.categorydto.ChildCategoryDto;
//import com.DemoProjectECommerce.ECommerce.model.productdto.ProductDto;
//import com.DemoProjectECommerce.ECommerce.model.productdto.ProductVariationDto;
//import com.DemoProjectECommerce.ECommerce.model.productdto.ProductViewCustomerDto;
//import com.DemoProjectECommerce.ECommerce.repositories.categoryrepository.CategoryRepository;
//import com.DemoProjectECommerce.ECommerce.repositories.productrepository.ProductRepository;
//import com.DemoProjectECommerce.ECommerce.repositories.productrepository.ProductVariationRepository;
//import com.DemoProjectECommerce.ECommerce.repositories.sellerrepository.SellerRepository;
//import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class ProductService
//{
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    ModelMapper    modelMapper;
//
//    @Autowired
//    EmailSenderService emailSenderService;
//    @Autowired
//    SellerRepository   sellerRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @Autowired
//    ProductVariationRepository productVariationRepository;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    public void addProduct(String email, ProductDto productDto)
//    {
//        User user=userRepository.findByEmailLike(email)
//                                .orElseThrow(()-> new ECommerceApplicationException("User not found"));
//        Seller seller=sellerRepository.findByUser(user)
//                                      .orElseThrow(()-> new ECommerceApplicationException("Seller not found"));
//        Category category=categoryRepository
//                .findById(productDto
//                                  .getCategoryId())
//                .orElseThrow(()-> new ECommerceApplicationException("Category Not Found"));
//        Product product =new Product();
//        if(productRepository.findProductName(productDto.getBrand(), productDto.getCategoryId(), seller.getId()).contains(productDTO.getName()))
//            throw new ECommerceApplicationException("Product already exists!");
//
//        if(!category.getChildCategoryId().isEmpty())
//        {
//            throw new ECommerceApplicationException("Not a leaf node category");
//        }
//
//        product.setName(productDto.getName());
//        product.setBrand(productDto.getBrand());
//        if(productDto.getDescription()!=null)
//            product.setDescription(productDto.getDescription());
//        product.setIs_cancellable(productDto.is_cancelled());
//        product.setIs_returnable(productDto.is_returnable());
//        product.setCategory(category);
//        product.setSeller((Set<Seller>) seller);
//
//        productRepository.save(product);
//
//    }
//    public void updateProduct(String email, ProductDto productDto,Integer id)
//    {
//        System.out.println("Reached......");
//        User user=userRepository.findByEmailLike(email)
//                                .orElseThrow(()-> new ECommerceApplicationException("User not found"));
//        Seller seller=sellerRepository.findByUser(user)
//                                      .orElseThrow(()-> new ECommerceApplicationException("Seller not found"));
//
//        Product product=productRepository
//                .findById(Long.valueOf(id))
//                .orElseThrow(()-> new ECommerceApplicationException("Product Not found for corresponding Id"));
//        Category category=product.getCategory();
//
//        if(!product.getSeller().equals(seller))
//        {
//            throw new ECommerceApplicationException("Product not found for corresponding seller");
//        }
//        if(productRepository.findProductName(productDto.getBrand(), productDto.getCategoryId(), seller.getId()).contains(productDTO.getName()))
//            throw new ECommerceApplicationException("Product already exists!");
//
//        if(!category.getChildCategoryId().isEmpty())
//        {
//            throw new ECommerceApplicationException("Not a leaf node category");
//        }
//
//        if(productDto.getName()!=null)
//            product.setName(productDto
//                                    .getName());
//        product.setBrand(productDto.getBrand());
//        if(productDto.getDescription()!=null)
//            product.setDescription(productDto.getDescription());
//        product.setIs_cancellable(productDto.is_cancelled());
//        product.setIs_returnable(productDto.is_returnable());
//
//
//        productRepository.save(product);
//
//    }
//    public ProductViewCustomerDto viewProductForCustomer(Integer id) {
//        Product product=productRepository.findById(Long.valueOf(id)).orElseThrow(()-> new ECommerceApplicationException("Product Not Found"));
//
//        Set<ProductVariation> productVariation =product.getProductVariations();
//        Category              category         =product.getCategory();
//        ChildCategoryDto categoryDto =new ChildCategoryDto();
//        categoryDto.setId(category.getId());
//        categoryDto.setName(category.getName());
//        ProductViewCustomerDto productViewDTO=new ProductViewCustomerDto();
//        modelMapper.map(product,productViewDTO);
//        Set<ProductVariationDto> productVariationDTOSet=  productVariation.stream().map(e->{
//            ProductVariationDto productVariationDTO=new ProductVariationDto();
//            modelMapper.map(e,productVariationDTO);
//            return productVariationDTO;
//        }).collect(Collectors.toSet());
//        productViewDTO.setProductVariation(productVariationDTOSet);
//        productViewDTO.setCategory(categoryDto);
//
//        return productViewDTO;
//    }
//
//    public List<ProductViewCustomerDto> viewProductListForCustomer(Integer id, Pageable pageable) {
//
//        Category category1=categoryRepository
//                .findById(Long.valueOf(id))
//                .orElseThrow(()-> new ECommerceApplicationException("Category Not Found"));
//        if(category1.getProduct().isEmpty())
//        {
//            throw new ECommerceApplicationException("Not a leaf node category");
//        }
//        Page<Product> productPage =productRepository.findAll(pageable);
//
//
//        List<ProductViewCustomerDto> productDtoList = productPage.stream().filter(x-> (x.getCategory().getId().equals(category1.getId()))&&x.isActive()&&(!x.isDeleted())).map(x -> {
//
//            Set<ProductVariation> productVariation=x.getProductVariations();
//            Category category=x.getCategory();
//            ChildCategoryDto categoryDto=new ChildCategoryDto();
//            categoryDto.setId(category.getId());
//            categoryDto.setName(category.getName());
//            ProductViewCustomerDto productViewDTO=new ProductViewCustomerDto();
//            modelMapper.map(x,productViewDTO);
//            Set<ProductVariationDto> productVariationDTOSet=  productVariation.stream().map(e->{
//                ProductVariationDto productVariationDTO=new ProductVariationDto();
//                modelMapper.map(e,productVariationDTO);
//                return productVariationDTO;
//            }).collect(Collectors.toSet());
//            productViewDTO.setProductVariation(productVariationDTOSet);
//            productViewDTO.setCategory(categoryDto);
//            productViewDTO.setName(x.getName());
//
//            return productViewDTO;
//        }).collect(Collectors.toList());
//        return productDtoList;
//    }
//    public List<ProductViewCustomerDto> viewSimilarProductListForCustomer(Integer id, Pageable pageable) {
//
//        Product product=productRepository
//                .findById(Long.valueOf(id))
//                .orElseThrow(()-> new ECommerceApplicationException("Product Not Found"));
//        Category category1=product.getCategory();
//        if(category1.getProducts().isEmpty())
//        {
//            throw new ECommerceApplicationException("Not a leaf node category");
//        }
//        Page<Product> productPage =productRepository.findAll(pageable);
//
//
//        List<ProductViewCustomerDto> productDtoList = productPage.stream().filter(x-> (x.getCategory().getId().equals(category1.getId()))&&x.isActive()&&(!x.isDeleted())).map(x -> {
//
//            Set<ProductVariation> productVariation=x.getProductVariations();
//            Category category=x.getCategory();
//            ChildCategoryDto categoryDto=new ChildCategoryDto();
//            categoryDto.setId(category.getId());
//            categoryDto.setName(category.getName());
//            ProductViewCustomerDto productViewDTO=new ProductViewCustomerDto();
//            modelMapper.map(x,productViewDTO);
//            Set<ProductVariationDto> productVariationDTOSet=  productVariation.stream().map(e->{
//                ProductVariationDto productVariationDTO=new ProductVariationDto()
//                        ;
//                modelMapper.map(e,productVariationDTO);
//                return productVariationDTO;
//            }).collect(Collectors.toSet());
//            productViewDTO.setProductVariation(productVariationDTOSet);
//            productViewDTO.setCategory(categoryDto);
//            productViewDTO.setName(x.getName());
//
//            return productViewDTO;
//        }).collect(Collectors.toList());
//        return productDtoList;
//    }
//    public List<ProductViewCustomerDto> viewProductListForAdmin(Pageable pageable) {
//
//
//        Page<Product> productPage =productRepository.findAll(pageable);
//
//
//        List<ProductViewCustomerDto> productDtoList = productPage.stream().filter(e-> e.getIs_active()&&(!e.getIs_deleted()) ).map(x -> {
//
//            Set<ProductVariation> productVariation=x.getProductVariations();
//            Category category=x.getCategory();
//            ChildCategoryDto categoryDto=new ChildCategoryDto();
//            categoryDto.setId(category.getId());
//            categoryDto.setName(category.getName());
//            ProductViewCustomerDto productViewDTO=new ProductViewCustomerDto();
//            modelMapper.map(x,productViewDTO);
//            Set<ProductVariationDTO> productVariationDTOSet=  productVariation.stream().map(e->{
//                ProductVariationDTO productVariationDTO=new ProductVariationDTO();
//                modelMapper.map(e,productVariationDTO);
//                return productVariationDTO;
//            }).collect(Collectors.toSet());
//            productViewDTO.setProductVariation(productVariationDTOSet);
//            productViewDTO.setCategory(categoryDto);
//            productViewDTO.setName(x.getName());
//
//            return productViewDTO;
//        }).collect(Collectors.toList());
//        return productDtoList;
//    }
//    public ProductViewCustomerDTO viewProductForAdmin(Integer id) {
//        Product product=productRepository.findById(Long.valueOf(id)).orElseThrow(()-> new ProductNotFound("Product Not Found"));
//
//        Set<ProductVariation> productVariation=product.getProductVariations();
//        Category category=product.getCategory();
//        ChildCategoryDto categoryDto=new ChildCategoryDto();
//        categoryDto.setId(category.getId());
//        categoryDto.setName(category.getName());
//        ProductViewCustomerDTO productViewDTO=new ProductViewCustomerDTO();
//        modelMapper.map(product,productViewDTO);
//        Set<ProductVariationDTO> productVariationDTOSet=  productVariation.stream().map(e->{
//            ProductVariationDTO productVariationDTO=new ProductVariationDTO();
//            modelMapper.map(e,productVariationDTO);
//            return productVariationDTO;
//        }).collect(Collectors.toSet());
//        productViewDTO.setProductVariation(productVariationDTOSet);
//        productViewDTO.setCategory(categoryDto);
//
//        return productViewDTO;
//    }
//    public ProductViewDTO viewProduct(String email, Integer id) {
//        Product product=productRepository.findById(Long.valueOf(id)).orElseThrow(()-> new ProductNotFound("Product Not Found"));
//        if(product.isDeleted())
//            throw new ProductNotFound("Product does not exist");
//        User user=userRepository.findByEmailLike(email)
//                                .orElseThrow(()-> new UserNotFoundException("User not found"));
//        Seller seller=sellerRepository.findByUser(user)
//                                      .orElseThrow(()-> new UserNotFoundException("Seller not found"));
//        if(!product.getSeller().equals(seller))
//        {
//            throw new ProductNotFound("Product not found for particular seller");
//        }
//        Category category=product.getCategory();
//        ChildCategoryDto categoryDto=new ChildCategoryDto();
//        categoryDto.setId(category.getId());
//        categoryDto.setName(category.getName());
//        ProductViewDTO productViewDTO=new ProductViewDTO();
//        modelMapper.map(product,productViewDTO);
//        productViewDTO.setCategory(categoryDto);
//        return productViewDTO;
//    }
//    public List<ProductViewDTO> viewProductList(String email,Pageable pageable) {
//        Page<Product> productPage =productRepository.findAll(pageable);
//        User user=userRepository.findByEmailLike(email)
//                                .orElseThrow(()-> new UserNotFoundException("User not found"));
//        Seller seller=sellerRepository.findByUser(user)
//                                      .orElseThrow(()-> new UserNotFoundException("Seller not found"));
//
//        List<ProductViewDTO> productDtoList = productPage.stream().filter(e-> e.getSeller().equals(seller)).map(e -> {
//
//            ProductViewDTO productDto = new ProductViewDTO();
//            modelMapper.map(e, productDto);
//            return productDto;
//        }).collect(Collectors.toList());
//        return productDtoList;
//    }
//    public void addProductVariation(String email, ProductVariationDTO productVariationDTO)
//    {
//        Product product=productRepository.findById(productVariationDTO
//                                                           .getProductId())
//                                         .orElseThrow(()-> new ProductNotFound("Product not found"));
//        User user=userRepository.findByEmailLike(email)
//                                .orElseThrow(()-> new UserNotFoundException("User not found"));
//        Seller seller=sellerRepository.findByUser(user)
//                                      .orElseThrow(()-> new UserNotFoundException("Seller not found"));
//        Category category=product.getCategory();
//        if(!product.getSeller().equals(seller))
//            throw new ProductNotFound("Product Variation not found  for corresponding Seller");
//        if(productVariationDTO.getQuantityAvailable()<0)
//            throw new CustomException("Quantity should be greater than 0");
//        if(productVariationDTO.getPrice()<0)
//            throw new CustomException("Price should be greater than 0");
//        if(!product.isActive())
//            throw new ProductNotFound("Product is inactive");
//        if(product.isDeleted())
//            throw new ProductNotFound("Product not found");
//        ObjectMapper oMapper = new ObjectMapper();
//
//        Map<String, String> map = oMapper.convertValue(productVariationDTO.getVariationMetaData(), Map.class);
//        System.out.println("Map------------>"+map);
//        Set<String> categoryMetadataFieldList=new HashSet<>();
//
//        category.getCategoryMetadataFieldValues().stream().map(categoryMetadataFieldValues->{
//            List<String> myList = new ArrayList<>(Arrays.asList(categoryMetadataFieldValues.getValue().split(",")));
//
//            String res=map.values().toString().replace("[","").replace("]","");
//            System.out.println("Value--------->"+res);
//            if(!myList.contains(res))
//                throw new CustomException("Value does not match");
//            categoryMetadataFieldList.add(categoryMetadataFieldValues.getCategoryMetadataField().getMetaDataFieldName());
//
//            return 1;
//        }).collect(Collectors.toList());
//        System.out.println("Key Set----------->"+map.values());
//        if(!categoryMetadataFieldList.containsAll(map.keySet()))
//        {
//            throw new CustomException("Metadata Field does not exist");
//        }
//
//        System.out.println(map.values());
//        ProductVariation productVariation=new ProductVariation();
//
//        productVariation.setPrice(productVariationDTO.getPrice());
//
//        productVariation.setVariationMetaData(productVariationDTO.getVariationMetaData().toJSONString());
//        productVariation.setQuantityAvailable(productVariationDTO.getQuantityAvailable());
//        productVariation.setProduct(product);
//        productVariation.setActive(true);
//        productVariationRepository.save(productVariation);
//
//    }
//    public void updateProductVariation(String email, ProductVariationDTO productVariationDTO,Integer id)
//    {
//        ProductVariation productVariation=productVariationRepository
//                .findById(Long.valueOf(id))
//                .orElseThrow(()-> new ProductNotFound("Production Variation not found"));
//        Product product=productVariation.getProduct();
//
//        User user=userRepository.findByEmailLike(email)
//                                .orElseThrow(()-> new UserNotFoundException("User not found"));
//        Seller seller=sellerRepository.findByUser(user)
//                                      .orElseThrow(()-> new UserNotFoundException("Seller not found"));
//        Category category=product.getCategory();
//        if(!product.getSeller().equals(seller))
//            throw new ProductNotFound("Product Variation not found  for corresponding Seller");
//        if(!product.isActive())
//            throw new ProductNotFound("Product is inactive");
//        if(product.isDeleted())
//            throw new ProductNotFound("Product not found");
//        ObjectMapper oMapper = new ObjectMapper();
//
//        Map<String, String> map = oMapper.convertValue(productVariationDTO.getVariationMetaData(), Map.class);
//
//        Set<String> categoryMetadataFieldList=new HashSet<>();
//
//        category.getCategoryMetadataFieldValues().stream().map(categoryMetadataFieldValues->{
//            List<String> myList = new ArrayList<>(Arrays.asList(categoryMetadataFieldValues.getValue().split(",")));
//
//            String res=map.values().toString().replace("[","").replace("]","");
//            System.out.println(res);
//            if(!myList.contains(res))
//                throw new CustomException("Value does not match");
//            categoryMetadataFieldList.add(categoryMetadataFieldValues.getCategoryMetadataField().getMetaDataFieldName());
//
//            return 1;
//        }).collect(Collectors.toList());
//
//        if(!categoryMetadataFieldList.containsAll(map.keySet()))
//        {
//            throw new CustomException("Metadata Field does not exist");
//        }
//
//        System.out.println(map.values());
//
//        if(productVariationDTO.getPrice()!=null)
//            productVariation.setPrice(productVariationDTO.getPrice());
//        if(productVariationDTO.getVariationMetaData()!=null)
//            productVariation.setVariationMetaData(productVariationDTO.getVariationMetaData().toJSONString());
//        if(productVariationDTO.getQuantityAvailable()!=null)
//            productVariation.setQuantityAvailable(productVariationDTO.getQuantityAvailable());
//
//        productVariation.setActive(true);
//        productVariationRepository.save(productVariation);
//
//    }
//    public ProductVariationResponseDTO viewProductVariation(String email, Integer id) {
//
//        ProductVariation productVariation=productVariationRepository
//                .findById(Long.valueOf(id))
//                .orElseThrow(()-> new ProductNotFound("Product Variation Not Found"));
//        Product product=productVariation.getProduct();
//
//        User user=userRepository.findByEmailLike(email)
//                                .orElseThrow(()-> new UserNotFoundException("User not found"));
//        Seller seller=sellerRepository.findByUser(user)
//                                      .orElseThrow(()-> new UserNotFoundException("Seller not found"));
//
//        if(!product.getSeller().equals(seller))
//            throw new ProductNotFound("Product Variation not found  for corresponding Seller");
//        ProductVariationResponseDTO productViewDTO=new ProductVariationResponseDTO();
//
//        ProductDTO productDTO=new ProductDTO();
//        modelMapper.map(product,productDTO);
//        modelMapper.map(productVariation,productViewDTO);
//        productViewDTO.setParentProduct(productDTO);
//
//
//        productViewDTO.setVariationMetaData(JSONValue.parse(productVariation.getVariationMetaData()));
//
//        return productViewDTO;
//    }
//    public List<ProductVariationResponseDTO> viewProductVariationList(String email,Pageable pageable) {
//        Page<ProductVariation> productVariationPage =productVariationRepository.findAll(pageable);
//        User user=userRepository.findByEmailLike(email)
//                                .orElseThrow(()-> new UserNotFoundException("User not found"));
//        Seller seller=sellerRepository.findByUser(user)
//                                      .orElseThrow(()-> new UserNotFoundException("Seller not found"));
//
//        List<ProductVariationResponseDTO> productDtoList = productVariationPage.stream().filter(e-> e.getProduct().getSeller().equals(seller)).map(e -> {
//
//            Product product=e.getProduct();
//            ProductVariationResponseDTO productViewDTO=new ProductVariationResponseDTO();
//
//            ProductDTO productDTO=new ProductDTO();
//            modelMapper.map(product,productDTO);
//            modelMapper.map(e,productViewDTO);
//            productViewDTO.setParentProduct(productDTO);
//
//            productViewDTO.setVariationMetaData(JSONValue.parse(e.getVariationMetaData()));
//
//            return productViewDTO;
//        }).collect(Collectors.toList());
//        return productDtoList;
//    }
//    public String activateProduct(Long id) throws MailException, InterruptedException {
//        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFound("Product Not Found"));
//        Seller seller=sellerRepository.findByUser(product.getSeller().getUser()).get();
//        User user= userRepository.findByEmail(seller.getUser().getEmail()).get();
//
//
//        if (!product.isActive()) {
//            product.setActive(true);
//            productRepository.save(product);
//            emailService.customEmail(user,"Product Activated","Product is now activated");
//
//            return "Product is now activated!";
//        }
//        return "Product is already activated";
//
//    }
//
//    public String deactivateProduct(Long id) throws MailException, InterruptedException {
//        Product product = productRepository.findById(Long.valueOf(id)).orElseThrow(()-> new ProductNotFound("Product Not Found"));
//        Seller seller=sellerRepository.findByUser(product.getSeller().getUser()).get();
//        User user= userRepository.findByEmail(seller.getUser().getEmail()).get();
//
//
//        if (product.isActive()) {
//            product.setActive(false);
//            productRepository.save(product);
//            emailService.customEmail(user,"Product Deactivated","Product is now deactivated");
//
//            return "Product is now deactivated!";
//        }
//        return "Product is already deactivated";
//
//    }
//
//    public String deleteById(Long id)  {
//        Product product=productRepository.findById(id).orElseThrow(()-> new ProductNotFound("Product Not Found"));
////        productRepository.deleteById(id);
//        product.setDeleted(true);
//        return "Product deleted";
//
//
//    }
//
//}
