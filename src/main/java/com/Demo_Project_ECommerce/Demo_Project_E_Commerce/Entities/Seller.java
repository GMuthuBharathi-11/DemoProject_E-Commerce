package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

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
@Entity
@Table(name="seller")
public class Seller
{
    //Setting Parameters for Seller

    @Id
    private Long User_Id;             // foreign key for (Seller_Table)
    private  String Gst_No;
    private String Company_Contact;
    private String Company_Name;

    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = " User_Id",referencedColumnName = "Id")
    private User user;
}
