//package com.DemoProjectECommerce.ECommerce.entity;
//
//import javax.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.Set;
//
//
//@Getter
//@Setter
//@Entity
//@Table(name= "product")
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Long Id;
//
//    private String  Name;
//    private String  Description;
//    private String  Is_cancellable;
//    private String  Is_returnable;
//    private String  Brand;
//    private boolean Is_active;
//    private boolean Is_deleted;
//
////    @ManyToOne(cascade = CascadeType.ALL)
////    private String parentId;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Category              category;
//    private Set<ProductVariation> ProductVariations;
//    private Set<Seller>           Seller;
//}
