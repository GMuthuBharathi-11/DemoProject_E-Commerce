package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // primary key
    private Long   Id;
    private String City;
    private String State;
    private String addressLine;
    private String Country;
    private String ZipCode;
    private String Label;
//    private Long   User_Id;                                     // foreign key
//
//    @ManyToOne
//    @JoinColumn(name = "customer_user_id")
//    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "user_table_id")
//    private User user;

}
