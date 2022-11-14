package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
    private String Address_Line;
    private Long Zip_Code;
    private String Label;
    private Long User_Id;                                   // foreign key

}
