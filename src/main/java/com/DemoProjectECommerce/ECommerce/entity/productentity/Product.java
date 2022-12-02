//package com.DemoProjectECommerce.ECommerce.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@Entity
//@Table(name= "product")
//public class Product
//{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Long   Id;
//    private String Name;
//    private String Description;
//    private String Is_cancellable;
//    private String Is_returnable;
//    private String Brand;
//    private String Is_active;
//    private String Is_deleted;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private String parent_id;
//    @OneToOne(cascade = CascadeType.ALL)
//    private User   user;
//
//
//}
