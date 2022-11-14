package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Seller
{
    //Setting Parameters for Seller

    @Id
    private Long User_Id;             // foreign key for (Seller_Table)
    private  String Gst;
    private long Company_Contact;
    private String Company_Name;
}
