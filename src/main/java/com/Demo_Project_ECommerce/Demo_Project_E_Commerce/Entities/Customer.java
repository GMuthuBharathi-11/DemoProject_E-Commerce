package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
