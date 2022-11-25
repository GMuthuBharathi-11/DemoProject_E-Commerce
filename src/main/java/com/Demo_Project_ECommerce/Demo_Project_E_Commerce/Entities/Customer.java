package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.util.Set;
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer
{

    //Setting Parameters for Customer

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;              //Foreign Key taking reference from User_role
    private String Contact_No;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private Set<Address> addressSet;

    public void setPassword(String encodedPassword)
    {

    }
    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
