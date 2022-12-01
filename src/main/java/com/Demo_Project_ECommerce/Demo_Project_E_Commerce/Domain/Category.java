//package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name ="category")
//public class Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer categoryId;
//    @Column(name = "category_name")
//    private @NotBlank String categoryName;
//
//    @OneToOne(targetEntity = Seller.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "Id", referencedColumnName = "Id")
//    @Column(name= "category_parent_id")
//    private String parent_Id;
//
//}
//
