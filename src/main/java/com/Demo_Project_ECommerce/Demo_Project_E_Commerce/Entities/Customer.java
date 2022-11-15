package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customer")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer
{

    //Setting Parameters for Customer

    @Id
    private long User_Id;              //Foreign Key taking reference from (User_Role)
    private String Contact_no;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private Set<Address> addressSet;




}
