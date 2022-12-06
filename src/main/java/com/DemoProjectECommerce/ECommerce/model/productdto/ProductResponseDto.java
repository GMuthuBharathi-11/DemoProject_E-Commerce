package com.DemoProjectECommerce.ECommerce.model.productdto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto
 {
     private Object variationMetaData;
     private Integer quantityAvailable;
     private Double price;
     private ProductDto parentProduct;

}
