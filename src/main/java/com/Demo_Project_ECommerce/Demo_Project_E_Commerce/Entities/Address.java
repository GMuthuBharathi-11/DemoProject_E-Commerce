package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@SuperBuilder
@Entity
@Table(name="address")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)         // primary key
    private Long Id;
    private String City;
    private String State;
    private String addressLine;
    private String Country;
    private Long Zip_Code;
    private String Label;
     private Long User_Id;                                     // foreign key

    @ManyToOne
    @JoinColumn(name = "customer_user_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_table_id")
    private User user;

}
